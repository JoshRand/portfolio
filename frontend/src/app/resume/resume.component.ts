import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-resume',
  templateUrl: './resume.component.html',
  styleUrls: ['./resume.component.css']
})
export class ResumeComponent implements OnInit {

  languages = [
    {name:"Java", proficiency:90},
    {name:"C#", proficiency:90},
    {name:"C++", proficiency:85},
    {name:"SQL", proficiency:85},
    {name:"JavaScript", proficiency:70}, 
    {name:"TypeScript", proficiency:70}, 
    {name:"Python", proficiency:60}, 
    {name:"HTML5", proficiency:60}, 
    {name:"CSS", proficiency:60}
  
  ];

  frameworks = [

    {name:"REST API", proficiency:90}, 
    {name:"Springboot", proficiency:80},
    {name:"Angular", proficiency:70}, 
    {name:"Express.JS", proficiency:40},
    {name:"Nginx", proficiency:40},
    {name:".NET", proficiency:20},
  
  ];

  devTools = [
    {name:"Visual Studio Code", proficiency:93}, 
    {name:"Visual Studio", proficiency:90},
    {name:"IntelliJ", proficiency:90},
    {name:"Postman", proficiency:90},
    {name:"Vim", proficiency:85},
    {name:"Unity", proficiency:80},
    {name:"Kafka", proficiency:80},
    {name:"Git", proficiency:80},
    {name:"Eclipse", proficiency:80},
    {name:"Docker", proficiency:70}, 
    {name:"Kubernetes", proficiency:60},
    {name:"PuTTY", proficiency:40},

  
  ];
  workExperienceAscendionSenior = 
  [
    "Enhanced the pre-existing ICE Platform's AZURE cloud cost usage scanning service by optimizing scan completion speed by an impressive 60%. Additionally, integrated an innovative overwrite feature to facilitate re-scanning of previous days.",
    "Developed a dynamic PDF library with versatile capabilities including paragraph addition, banner incorporation, concatenation of diverse PDF pages, and seamless upload of the generated PDFs to either Amazon's S3 buckets or AZURE's Blob Storage.",
    "Pioneered the implementation of a service utilizing the JSch library, enabling automated Secure Shell (SSH) access to an AZURE Virtual Machine.",
    "This approach facilitated efficient saving and logging of vital process metrics, contributing to enhanced operational insights."
  ];

  workExperienceAscendionAssociate = 
  [
    
      "Converted existing Flask APIs within the IAF platform to Java SpringBoot REST APIs which increased the speed of database operations by 20%.",
      "Worked on multiple AVA platforms that leveraged AI, ML, and automation.",
      "Implemented an API for AVA’s Evaluation platform to grade user feedback.",
      "Improved the existing AVA platforms IAF and ITA, and implemented Mockito unit tests along with the JaCoCo plugin to achieve code coverage above 80%.",
      "Used advanced analytical skills to speedily debug and implement fixes for a production ready environment.",
      "Designed and Implemented a message broker API service which allows the user to send asynchronous messages to other REST services using Kafka and Zookeeper.",
      "Maintained multiple PostgreSQL databases and schemas.",
      "Created a service that utilizes a third party Readability REST API alongside the Jsoup Library to grade a website's reading level.",
      "Managed Kubernetes helm charts across multiple scalable platforms."
      
    
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
