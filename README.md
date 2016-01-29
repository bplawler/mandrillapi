mandrillapi
===========

Typesafe wrapper around the Mandrill APIs.  Currently impelmented functions are:

* Sending messages
* Receiving webhooks about those messages

## Receiving Webhooks

This repo contains a Play module that may be plugged into your application whose
job it is to receive Webhook calls from Mandrill.  The module defines the necessary
routes, controllers, and utility classes for handling the communication.  All you 
have to do is tell Mandrill where to send the webhooks and provide an implementation
of what to do with the webhooks that you receive.

### Registering Your Webhook with Mandrill

### Defining Your Webhook Logic

The WebhookProcessor interface defines an interface contract that applications need
to implement in order to plug in to this framework.  The interfaces are all defined
in Java and are easily implemented either in Java or Scala.  
