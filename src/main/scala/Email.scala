package mandrillapi.impl

import scala.collection.JavaConverters._

import org.codehaus.jackson.map.ObjectMapper
import org.codehaus.jackson.map.PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.HttpClientBuilder
import com.typesafe.config.{ConfigException, ConfigFactory}

object Email {
  val config = ConfigFactory.load()
}

class Email extends mandrillapi.api.Email {
  var to: mandrillapi.api.User = null
  var template: String = null
  var mergeVars = scala.collection.mutable.Map[String, String]()

  private val mapper = new ObjectMapper
  mapper.setPropertyNamingStrategy(new LowerCaseWithUnderscoresStrategy)

  def setTo(user: mandrillapi.api.User) = {
    to = user
    this 
  }
  def setTemplate(template: String): Email  = { 
    this.template = template
    this 
  }
  def addMergeVariable(name: String, value: String): Email = { 
    mergeVars.put(name, value)
    this
  }

  def send = {
    val msg = new mandrillapi.api.mandrill.SendTemplate {
      def getKey = Email.config.getString("mandrillapi.key")
      def getTemplateName = template;
      def getTemplateContent = List[mandrillapi.api.mandrill.SendTemplate.ContentVar]().asJava
      def getMessage = new mandrillapi.api.mandrill.SendTemplate.Message {
        def getSubject = null
        def getFromEmail = Email.config.getString("mandrillapi.sendTemplate.fromEmail")
        def getFromName = Email.config.getString("mandrillapi.sendTemplate.fromName")
        def getGlobalMergeVars = {
          mergeVars.map { kv => 
            new mandrillapi.api.mandrill.SendTemplate.ContentVar {
              def getName = kv._1
              def getContent = kv._2
            }
          }
          .toList
          .asJava
        }
        def getTo = Option(to)
          .map { toUser => {
            List(new mandrillapi.api.mandrill.SendTemplate.Message.To {
              def getEmail = toUser.getEmail
              def getName = List(Option(toUser.getFirstName), Option(toUser.getLastName))
                              .flatten
                              .mkString(" ")
              def getType = "to"
            }).asJava
          }}
          .getOrElse {
            throw new mandrillapi.api.ex.NoRecipient
          }
      }
    }

    val client = HttpClientBuilder.create.build
    try {
      val endpoint = "https://mandrillapp.com/api/1.0/messages/send-template.json"
      val post = new HttpPost(endpoint)
      val body = mapper.writeValueAsString(msg)
      val input = new StringEntity(body)
      input.setContentType("application/json")
      post.setEntity(input)
      System.out.println("sending body\n\n%s".format(body))
      val response = client.execute(post);
      if (response.getStatusLine.getStatusCode != 200) {
        throw new Exception("Failed : HTTP error code : "
          + response.getStatusLine().getStatusCode());
      }
    }
    catch {
      case e: Exception => throw new RuntimeException(e)
    }
    finally {
      client.close();
    }
  }
}
