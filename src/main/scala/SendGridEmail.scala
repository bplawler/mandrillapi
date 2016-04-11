package mandrillapi.impl

import scala.collection.JavaConverters._
import com.typesafe.config.{ConfigException, ConfigFactory}

class SendgridEmail extends mandrillapi.api.Email {
  var to: Set[mandrillapi.api.User] = Set()
  var template: String = null
  var subject: String = null
  var googleDomain = List[String]()
  var googleCampaign: String = null
  var mergeVars = scala.collection.mutable.Map[String, String]()
  var tpltContent = scala.collection.mutable.Map[String, String]()

  def addTo(email: String): mandrillapi.api.Email = {
    to += new mandrillapi.api.User {
      def getFirstName = null
      def getLastName = null
      def getEmail = email
    }
    this
  }
  def addTo(user: mandrillapi.api.User) = {
    to += user
    this 
  }
  def setTemplate(template: String): mandrillapi.api.Email  = { 
    this.template = template
    this 
  }
  def setSubject(subject: String): mandrillapi.api.Email  = { 
    this.subject = subject
    this 
  }
  def addMergeVariable(name: String, value: String): mandrillapi.api.Email = { 
    mergeVars.put(name, value)
    this
  }
  def addTemplateContent(name: String, value: String): mandrillapi.api.Email = { 
    tpltContent.put(name, value)
    this
  }
  def setGoogleAnalyticsCampaign(s: String): mandrillapi.api.Email = {
    googleCampaign = s
    this
  }
  def setGoogleAnalyticsDomain(s: String): mandrillapi.api.Email = {
    googleDomain = List(s)
    this
  }

  def send = {
    val msg = new com.sendgrid.SendGrid.Email()
    to.foreach { user => 
      msg.addTo(user.getEmail, 
        List(Option(user.getFirstName), Option(user.getLastName))
          .flatten.mkString(" ")
      )
    }
    msg.setFrom("ops@lynxworkflow.com")
    msg.setFromName("FactBox")
    msg.setSubject(
      Email.config.getString(s"sendgrid.message.${template}.subject"))
    msg.setTemplateId(
      Email.config.getString(s"sendgrid.message.${template}.templateId"))
    msg.setHtml(
      Email.config.getString(s"sendgrid.message.${template}.body"))
    mergeVars.foreach { case (key, value) => 
      msg.addSubstitution(key, List(value).toArray)
    }

    val id = s"${to.head.getEmail}-${(new java.util.Date).getTime}"
    Email.sendgrid.send(msg) match {
      case r: com.sendgrid.SendGrid.Response =>
        Map(id -> new mandrillapi.api.mandrill.SendResponse { 
          def getEmail = to.head.getEmail
          def getStatus = r.getStatus.toString
          def getRejectReason = r.getMessage
          def getId = id
        }).asJava
    }
  }
}
