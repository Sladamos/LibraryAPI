<!-- Improved compatibility of back to top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->
<a name="readme-top"></a>
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->



<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![LinkedIn][linkedin-shield]][linkedin-url]


<h3 align="center">Library API</h3>

  <p align="center">
    Simple application for books management
    <br />
    <a href="https://github.com/Sladamos/LibraryAPI/issues/new?labels=bug&template=bug-report---.md">Report Bug</a>
    ·
    <a href="https://github.com/Sladamos/LibraryAPI/issues/new?labels=enhancement&template=feature-request---.md">Request Feature</a>
  </p>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
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
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project
<p style="text-align: justify">
Library API is an application divided into microservices which are deployed on Heroku. It consists of books and publishing houses. It allows simple CRUD operations on both books and publishing houses. The goal of the project was to create monolith and then divide it into separate microservices with their own persistence (one instance per domain). It was required to develop these microservices to communicate synchronously (RestTemplate). The project also contains simple UI created with Angular to give better experience.</p>

<p align="right">(<a href="#readme-top">back to top</a>)</p>



### Built With

* [![Docker][Docker.com]][Docker-url]
* [![Spring][Spring.io]][Spring-url]
* [![Angular][Angular.io]][Angular-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

### Prerequisites

Be sure that Docker is installed on your machine.

### Env variables

To properly launch an application, you should create those enviromental files:
<ul>
    <li>books-db.env</li>
    <li>publishing-houses-db.env</li>
    <li>postgres-library-books.env</li>
    <li>postgres-library-publishing-houses.env</li>
    <li>library-eureka.env</li>
    <li>library-gateway.env</li>
    <li>library-front.env</li>
</ul>

Both dbs should contain
<ul>
    <li>POSTGRES_DB</li>
    <li>POSTGRES_USER</li>
    <li>POSTGRES_PASSWORD</li>
</ul>

Front should countain:
```API_URL=http://library-gateway:8084/api/```

Other env can be created based on proper application.properties. If you want to have access to API from your browser, write this line in library-gateway.env:
```LIBRARY_GATEWAY_USER_HOST=localhost:8084```

If you have any troubles with your URLs check Docker documentation about networks.

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/Sladamos/LibraryAPI.git
   ```
2. Provide necessary privilleges for building and launching scripts
3. Build application with Docker
   ```sh
   ./build.sh
   ```
4. Launch application with Docker-compose
   ```sh
   ./launch_app.sh
   ```
5. Check if everything works on localhost:8085/publishing-houses

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Feel free to catch me on Linkedin: &nbsp;[![LinkedIn][linkedin-shield]][linkedin-url]

Project Link: [https://github.com/Sladamos/LibraryAPI](https://github.com/Sladamos/LibraryAPI)

<p align="right">(<a href="#readme-top">back to top</a>)</p>




<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/Sladamos/LibraryAPI.svg?style=for-the-badge
[contributors-url]: https://github.com/Sladamos/LibraryAPI/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/Sladamos/LibraryAPI.svg?style=for-the-badge
[forks-url]: https://github.com/Sladamos/LibraryAPI/network/members
[stars-shield]: https://img.shields.io/github/stars/Sladamos/LibraryAPI.svg?style=for-the-badge
[stars-url]: https://github.com/Sladamos/LibraryAPI/stargazers
[issues-shield]: https://img.shields.io/github/issues/Sladamos/LibraryAPI.svg?style=for-the-badge
[issues-url]: https://github.com/Sladamos/LibraryAPI/issues
[license-shield]: https://img.shields.io/github/license/Sladamos/LibraryAPI.svg?style=for-the-badge
[license-url]: https://github.com/Sladamos/LibraryAPI/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/linkedin_username
[product-screenshot]: images/screenshot.png
[Docker.com]: https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white
[Docker-url]: https://www.docker.com/
[Spring.io]: https://img.shields.io/badge/SpringBoot-6DB33F?style=flat-square&logo=Spring&logoColor=white
[Spring-url]: https://spring.io/
[Angular.io]: https://img.shields.io/badge/Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white
[Angular-url]: https://angular.io/
