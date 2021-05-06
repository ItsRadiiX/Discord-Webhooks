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
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgements">Acknowledgements</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

Definity Webhooks is an free to use API for sending messages to your Discord Webhooks!
It allows for easy message building due to its Builder class. (More up ahead)

Currently the API supports the following:
- Custom webhook username
- Custom avatar URL
- Custom content message
- Easy creation of embedded messages and all its properties.
- - Embed title
- - Embed description
- - Title URL
- - Embed color
- - Footer icon URL & text
- - Footer TimeStamp
- - Thumbnail URL
- - Image URL
- - Custom author: name, URL + icon URL
- - Fields: used to create additional message field in the embed (Support for blank space)


### Built With

* [OpenJDK 8](https://adoptopenjdk.net/)
* [Maven](https://maven.apache.org/)
* [Gson](https://github.com/google/gson)
* [Json](https://mvnrepository.com/artifact/org.json/json)



<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow these simple steps.

### Prerequisites

* [Json](https://mvnrepository.com/artifact/org.json/json)
* [Gson](https://github.com/google/gson)

### Installation

Currently the only way to add Definity WebHooks is by adding the jar to your local maven repository.
I will upload Definity WebHooks to the public maven repository in the near future.

1. Download latest JAR from releases section.
2. Add JAR file to your local maven repository.
   Don't forget to replace <path-to-jar-file> with the path to your file
   ```sh
   mvn install:install-file -Dfile=<path-to-jar-file> -DpomFile=<path-to-jar-file>\META-INF\maven\com.itsradiix\DiscordWebHookAPI\pom.xml
   ```
   
   
   Or use the following:
   Don't forget to replace <path-to-jar-file> with the path to your file and insert the version in <version>
   ```sh
   mvn install:install-file -Dfile=<path-to-file> -DgroupId=com.itsradiix -DartifactId=DiscordWebHookAPI -Dversion=<version> -Dpackaging=jar
   ```


<!-- ROADMAP -->
## Roadmap

See the [open issues](https://github.com/ItsRadiiX/Definity-Webhooks/issues) for a list of proposed features (and known issues).



<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE` for more information.



<!-- CONTACT -->
## Contact

Bryan Suk - [ItsRadiiX#0001](https://discord.definitymc.com) - radiixbs@gmail.com

Project Link: [https://github.com/ItsRadiiX/Definity-Webhooks](https://github.com/ItsRadiiX/Definity-Webhooks)



<!-- ACKNOWLEDGEMENTS -->
## Acknowledgements

* [Introducing JSON](https://www.json.org/json-en.html)
* [Discord embed visualizer](https://leovoel.github.io/embed-visualizer/)
