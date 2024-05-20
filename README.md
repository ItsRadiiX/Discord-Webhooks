<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/ItsRadiiX/Definity-Webhooks">
    <img src="https://i.imgur.com/gXGTSRH.png" alt="Logo" width="800" height="400">
  </a>

  <h3 align="center">Definity Webhooks</h3>

  <p align="center">
    API for sending Webhook messages to your Discord Webhooks
    <br />
    <a href="https://github.com/ItsRadiiX/Definity-Webhooks/wiki"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/ItsRadiiX/Definity-Webhooks/issues">Report Bug</a>
    .
    <a href="https://itsradiix.github.io/Definity-Webhooks/javadocs/">JavaDocs</a>
    ·
    <a href="https://github.com/ItsRadiiX/Definity-Webhooks/issues">Request Feature</a>
  </p>
</p>



<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary><h2 style="display: inline-block">Table of Contents</h2></summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgements">Acknowledgements</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

Definity Webhooks is a free to use API for sending messages to your Discord Webhooks!
It allows for easy message building due to the Builder design pattern.

Features available in version 1.0.3
- Custom webhook username
- Custom avatar URL
- Custom content message
- Easy creation of embedded messages and all its properties.
   - Embed title
   - Embed description
   - Title URL
   - Embed color
   - Footer icon URL & text
   - Footer TimeStamp
   - Thumbnail URL
   - Image URL
   - Custom author: name, URL + icon URL
   - Fields: used to create additional message field in the embed (Support for blank space)

Features added in version 2.0
- (Multiple) Custom File uploading
- Creating Polls
- Using attachments where need be
- Ability to set TTS
- Add message Flags
- Create a thread
- Apply Tags to a thread
- Custom mentioning of users, roles or everyone
- Usage or proxy URL



### Built With

* [OpenJDK 8](https://adoptopenjdk.net/)
* [Maven](https://maven.apache.org/)
* [Gson](https://github.com/google/gson)
* [Apache HttpClient5](https://mvnrepository.com/artifact/org.apache.httpcomponents.client5/httpclient5)



<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow these simple steps.

### Prerequisites

Currently, we only support depending on our project using Maven.
If you wish to use Gradle, you can download the latest JAR and import it directly in your project.

### Installation

Add the following to your pom.xml:

```
<dependency>
  <groupId>com.itsradiix</groupId>
  <artifactId>definity-webhookapi</artifactId>
  <version>latest</version>
</dependency>
```

<!-- ROADMAP -->
## Roadmap

See the [open issues](https://github.com/ItsRadiiX/Definity-Webhooks/issues) for a list of proposed features (and known issues).



<!-- LICENSE -->
## License

Check the LICENSE file in our project folder

<!-- CONTACT -->
## Contact

Bryan Suk - [ItsRadiiX](https://discordapp.com/users/286875783027228693) - mail@bryansuk.nl

Project Link: [https://github.com/ItsRadiiX/Definity-Webhooks](https://github.com/ItsRadiiX/Definity-Webhooks)



<!-- ACKNOWLEDGEMENTS -->
## Acknowledgements

* [Introducing JSON](https://www.json.org/json-en.html)
* [Discord embed visualizer](https://leovoel.github.io/embed-visualizer/)
