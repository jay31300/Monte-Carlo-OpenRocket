* # ENGR 301: Project Requirements Document

The aim of this document is to specify the requirements of the system your group is to build. The focus of a requirements document is the problem you are attempting to solve:  not a first attempt at a solution to that problem. This document should communicate clearly to the supervisor, client and course coordinator what the system you build is going to do, and what constraints it must meet while doing so.

The document should also demonstrate your understanding of the main analysis principles and quality guidelines, and applicable standards, using tools and notations as necessary to communicate the requirements precisely, unambiguously and clearly in a written technical document. Page specifications below are *limits not targets* and refer to the pages in the PDF generated from the markdown. Because the size of your document is necessarily limited, you should ensure that you focus your efforts on those requirements that are most important to completing a successful system: if sections are at their page limit, indicate how many items would be expected in a complete specification. 

The ENGR 301 project proposal and requirements document should be based on the standard ISO/IEC/IEEE 29148:2011(E), primarily sections 8.4 and 9.5, plus section 9.4 for projects involving hardware and ISO 25010 SQuaRE for systemic requirements. While excerpts from the standard have been quoted within the template, to understand what is required it will be necessary to read earlier sections of the standards themselves. A supplementary treatment of requirements gathering in engineering projects may be found in [Requirements in Engineering Projects](https://victoria.rl.talis.com/items/F166DA94-DAD8-FBDB-0785-7A63C9BA3603.html?referrer=%2Flists%2F5886F297-2506-1F17-45D9-7F04CEE284EE.html%23item-F166DA94-DAD8-FBDB-0785-7A63C9BA3603) (Talis). The requirements document should contain the sections listed below, and conform to the formatting rules listed at the end of this brief. 

All team members are expected to contribute equally to the document and list their contributions in section 6 of the document. You should work on your document in your team's GitLab repository. While collective contributions are expected to be the exception rather than the rule, if more than one team member has contributed to a particular commit then all those team member IDs should be included in the first line of the git commit message. `git blame`, `git diff`, file histories, etc. will be tools used to assess individual contributions, so everyone is encouraged to contribute individually, commit early and commit often. Any team wishing to separate individually contributed sections into a single file before collation into the single proposal document for submission is welcome to do so.

---

<div style="page-break-after: always;"></div>

# ENGR 301 Project *NN* Project Proposal and Requirements Document

Justine Lim-Ranola, Pragya Pradhan, Jaynesh	Patel, Joshua Richards, Jacob	Fraser, Alakai	Chapman,Isaac Irvine

## 1. Introduction

One page overall introduction including sections 1.1 and 1.2.


### Client

Identify the client and their contact details

Name: Andre Geldenhuis <br />
Organisation: Victoria University of Wellington <br />
Email: andre.geldenhuis@vuw.ac.nz

### 1.1 Purpose

This project has two main purposes.
The first purpose is to assess whether it is safe to fly a given rocket degine in a particular set of given enviromental factors. Including but not limited to weather and location. This is to help the rocket engineers designe a rocket that will be safe to fly in the real world. This is the Monte Carlo part of the project.
The other purpose of the simulation is to allow the engineers to work out estimates for the PID control parameters that can be used in a real life lanch. 

### 1.2 Scope

We will be using Open Rocket for the simulation. The project does not require us to make our own simulation. We will be making a user interface (probably graphical in some way) that makes it easy for someone to use the Open Rocket core to simulate multiple different environments and graph the landing locations in a scatter plot. This interface does not need to extend the current GUI. It can be a whole new GUI
We will also have to modify Open Rocket to add PID controllers and motor gimbaling. These will then be used for determining PID control parameter.

### 1.3 Product overview 

#### 1.3.1 Product perspective

The system that we are designing is part of a larger rocket production project with multiple teams, so our project is related to these other products. Our system is split into two parts. The first part is the ‘Monte Carlo’ simulation in which we automate the changing of parameters to give us a scatter plot of likely landing locations. The second part is to determine estimates for a PID controller for the motor of the rocket.

The larger rocket project as a whole relies heavily on the software tasks that we have been assigned. Since it is time consuming and expensive to design and produce a rocket, using practical launches to test the flight of the rocket would be ineffective. A team would have to recreate the rocket and adjust the parameters each time before another test launch.
Using software simulation can instead simulate the rocket and all its parameters without practical tests. The Monte Carlo simulation is required to determine the likely landing spots without ever leaving a computer screen, and the PID controller parameters are required to get the specifics of the motor correct before the rocket is ever launched. The project requires this type of simulation, so that money, materials, and time can be better spent of other areas.

We will be using the program ‘Open Rocket’ for both of our simulation tasks. This interface will allow us to design a rocket with many different materials and components. We will also use this program to simulate the flight of the rocket to determine the Monte Carlo scatter plot and PID controller parameters. If needed, we can communicate between groups using the chat service Mattermost, or something similar, to simulate rocket flight based on other groups practical designs.


#### 1.3.2 Product functions

The product we are developing is split into two parts; the Monte Carlo simulation and a PID controller. The main functions of the product are Monte Carlo simulations for range safety and site selection, and PID controller simulations for control tuning and design. These two main functions have sub-main functions under them. 

For the Monte Carlo simulation, the main functions are to simulate the rocket in OpenRocket with varying parameters and plot it on a scatterplot. The parameters here are the parachute ejection time, launch angle and motor performance. The purpose of this is to simulate the rocket’s potential performance and how its flight is affected when its parameters are changed. The generation of these parameters needs to be automated. The results of these are used to create a scatter plot of potential landing locations.

The minimum viable Monte Carlo product would automatically generate parameters for simulation and create a scatter plot of possible landing locations. This product can be used to determine whether a flight would be safe prior to the launch of the physical rocket.

For the PID controller, the main function is to simulate the controller and determine estimates for the PID control parameters. Determining the PID control parameter estimates will be done using simulation listeners. 

The minimum viable product for the PID controller aspect is working out estimates of for the PID control parameters through rocket simulation.


#### 1.3.3 User characteristics   

As per the client’s request, full-availability of the Monte Carlo simulation software will be afforded to the wider model rocket community, therefore the product is an open source software package. As such the package will provide a generalised control parameter set capable of being fine tuned for user-specific rocket requirements in order to provide more accurate simulations on a case by case basis. Furthermore no software specific training is needed to use the application. It should be noted however that users need a basic understanding of the methodology used in applying the package specific methods to better coincide with their own unique constraints. For example, users should be able to provide details about their environment, specific rocket parameters, potential weather conditions as well have a general understanding of probability and how likely each outcome is.

Advanced users, who have a deeper understanding of the Monte Carlo simulation software through technical expertise and experience are afforded greater levels of customisation throughout the application because of the open sourced nature. For example, advanced users could modify the control parameters to potentially feature more specific designs of their rocket such as material used, weight of specific components and unique conditions. It is also likely that users will have unique desired outcomes. Therefore it is recommended that users have PID experience, as this will be invaluable due to the sacrificial nature of fine-tuning the control parameters. For example Rocket X may intend to be flown to as high an elevation as possible, while Rocket Y needs to only make it half the distance but in half the time and therefore both will require different adjustments and will result in differing opportunity costs to the project.

Users with physical or mental disabilities should be vetted to ensure project safety. Any person or persons who fails this vetting process should be removed immediately due to health and safety concerns.


#### 1.3.4 Limitations

There are a number of limitations for our project that we need to consider. One of the most important being people. We have decided to split off into two teams of 3-4 people to complete the Monte Carlo simulation and PID controller portions of the project separately. The limitation here would be the availability of each person in each small team. Some people might have other work and prioritise different things, so we need to consider the limitations of workload for each person.

An important hardware limitation would be having a computer capable of running the open rocket program and simulating rocket launches, however this isn’t much of a limitation as nearly every computer these days is capable of such a task.

Another limitation would be the programming language we chose, in this case, java. We will be using Gradle to include dependencies in our java project to help mitigate limitations of the language. This will make it easier for us to do complex tasks with these dependencies.


## 2. References

References to other documents or standards. Follow the IEEE Citation  Reference scheme, available from the [IEEE website](https://www.ieee.org/) (please use the search box). (1 page, longer if required)

## 3. Specific requirements  

20 pages outlining the requirements of the system. You should apportion these pages across the following subsections to focus on the most important parts of your product.

### 3.1 External interfaces

As this is a software system there are no physical external interfaces that will interact with the system.
See 9.5.10. for most systems this will be around one page. 

### 3.2 Functions

This is typically the longest subsection in the document. List up to fifty use cases (in order of priority for development), and for at least top ten focal use cases, write a short goal statement and use case body (up to seven pages).  Identify the use cases that comprise a minimum viable product.

Use Cases (Rough Braintstorm)

#### Monte Carlo

Minimum viable product:
* A rocketry hobbyist wanting to simulate the rocket launch during a windy day.
* A rocketry hobbyist wanting to simulate the rocket launch during a clear day.
* A rocketry hobbyist wanting to ensure their rocket lands in an accessible location to them.
* A newbie rocketry hobbyist wanting to simulate the rocket flight process before making any decisions for actual rocketry-building (i.e. regarding parts).
* A rocketry hobbyiest wanting to see if their rocket launch will even be possible when factoring in weather conditions.
* A rocketry hobbyist wanting to test whether the maximum height of the launch will be greater than the legal limit.
* Mission Control Teams trying to simulate where the rocket may land after launch
* Mission Control carrying out a final, last-minute simulation before launch (double checking)
* A newbie interested in rocketry wanting to simulate how a rocket's flight will be like 
* A newbie wanting to test how different launch angles will affect the rocket flight
* A newbie playing around with different parameter combinations out of curiosity

Other use cases:
* A rocket maker wanting to ensure that their rocket’s ground-hit velocity won’t break the rocket.
* A rocketry hobbyist wanting to see if the location they have picked will be suitible for a rocket launch.
* A rocketry hobbyist wanting to test when the optimal time to launch the parachute is.
* A rocketry hobbyist wanting to test different engine parameters to get the optimal height.
* A rocketry hobbyist wanting to change the input wind variations by larger amounts
* A rocketry hobbyist wanting to find the average of many different rocket launches
* Mission Control choosing a launch site based on where the rocket may land 
* Mission Control inputting the launch site's current weather conditions 
* Mission Control simulating launch and flight with the launch site's current weather condition 
* A newbie wanting to test how different parachute ejection angles will affect the rocket flight

#### PID

* A rocketry hobbyist wanting to find the most ideal values for their PID controller
* Systems Teams needing PID simulated values to build their rocket


### 3.3 Usability Requirements

To fulfill the usability requirement, the program must make sure that adjustment of the positions of various components while building the rocket is flexible and easily changeable. It is because a slight change in the position can result in a slightly different output compared to the expected output. For this, the program will have the option to choose the units and change the size and position of each components. A bunch of buttons, drop down lists and sliders will be used in the GUI to make it as user friendly as possible.
The program is expected to be error free and fully functioning.

### 3.4 Performance requirements

**Human Interaction**
- It should take less than 10 clicks/actions for the user to plot the Monte Carlo scatter plot 

**Dynamic numerical requirements**
- The Monte Carlo plot should plot in less than 1 minutes for every 100 simulations. 
- Simulations should take less than 1 minute for every 100 simulations


### 3.5 Logical database requirements

See 9.5.14. for most systems, a focus on d) and e) is appropriate, such as an object-oriented domain analysis. You should provide an overview domain model (e.g.  a UML class diagram of approximately ten classes) and write a brief description of the responsibilities of each class in the model (3 pages).

You should use right tools, preferabley PlantUML, to draw your URL diagrams which can be easily embedded into a Mardown file (PlantUML is also supported by GitLab and Foswiki).

First rough plan for the open Rocket simulation: https://gitlab.ecs.vuw.ac.nz/course-work/engr300/2020/group17/group-17/-/blob/master/project_requirement/plan.pdf

### 3.6 Design constraints

see 9.5.15 and 9.5.16. for most systems, this will be around one page.

> 9.5.15 Design constraints<br>
> Specify constraints on the system design imposed by external standards, regulatory requirements, or project limitations.
>
> 9.5.16 Standards compliance<br>
> Specify the requirements derived from existing standards or regulations, including:
>
> a) Report format;<br>
> b) Data naming;<br>
> c) Accounting procedures;<br>
> d) Audit tracing.
>
> For example, this could specify the requirement for software to trace processing activity. Such traces are needed for some applications to meet minimum regulatory or financial standards. An audit trace requirement may, for example, state that all changes to a payroll database shall be recorded in a trace file with before and after values.

### 3.7 Nonfunctional system attributes

Present the systemic (aka nonfunctional) requirements of the product (see ISO/IEC 25010).
List up to twenty systemic requirements / attributes.
Write a short natural language description of the top nonfunctional requirements (approx. five pages).

Non-functional requirement
For this project, we will be focusing on the following system requirements:

•	Flexibility

-	One of the most important part of this project is user flexibility. The program has to make sure that it is able to support the most recent version of java as well as the older versions. It is because the java version keeps on updating frequently. Therefore to avoid any run time exceptions in the future from happening, testing the program with most of the recent and older version of java is important.  

•	Speed

-	For this project only having the simulation working properly is not enough. The program must make sure that the speed while running the simulation is fast enough even during highest workload, so that it does not take much time for the users to run their simulation.

•	Security

-	For security requirements, the source code of the system will not be distributed or provided online. Only the execution file of the system will be provided to the user to avoid the program getting changed easily. However, the system will have a special report section where the user can report an issue if there is any problem while running the simulation.


•   Easy of use and Efficiency 

-   This aspect is related to ensuring the users are able to reach their goal and desired action as efficiently as possible. 
    The GUI and the design of our program as a whole should allow for easy access and navigation to the program’s main functions.

•   Learnability

-   The program’s learnability is important to consider when thinking about the system. Since our program works alongside OpenRocket, it would be ideal to have a similar layout and program structure for users to learn how to use our program faster. The more difficult a program is to learn, the more likely a customer would get frustrated and stop using the program.

•   Memorability

-   Memorability is to do with the users coming back to use the program after some time and still being able to use it. Even after some time has passed, the program’s design should allow users to start working and using the program right away.

•   Robustness

-   As we do not know the uses’ experience level with rocketry and our system, it is important that the program we create is forgiving towards mistakes. 

•   Maintainability

- The program needs to be able to be patched easily if required. Also, if there is a bug or conflict with another plugin, the program has to be well structured enough to make changes to update the software. 

•   Survivability

- The program needs to be able to survive after it is released. This is anything from not being overtaken by a competitive program which is able to do the same thing that this program can do but better, whether this is by being faster than our program or using less system resources. To mitigate this risk, we will keep the program up to date with all the features and make sure that it lasts longer. Also, we will try to make our program efficient and fast so that it will not be overshadowed. 

### 3.8 Physical and Environmental Requirements 

As this is a software system, no hardware components are required.

### 3.9 Supporting information

see 9.5.19. 

## 4. Verification

3 pages outlining how you will verify that the product meets the most important specific requirements. The format of this section should parallel section 3 of your document (see 9.5.18). Wherever possible (especially systemic requirements) you should indicate testable acceptance criteria.

* Code Acceptance Criteria *

- The code must compile with no errors.
- Any code warnings should not affect the functionality of the program. 
- The code must pass with no Spotbugs errors.
- Javadoc comments and general code comments are used.


* Code Architecture/ Structure and Layout Criteria *
- Classes should be appropriately named and have proper Javadoc description
- Classes should be grouped by likeness when possible (i.e. test classes in a separate folder from program classes)
- Variables should be appropriately named. Any ambiguous variables should have a related code comment description
- Functions should be appropriately named. Javadocs should be used for functions.

Merge requests must be verified against these criteria by at least two(2) team members. Any comments on improvement made by team members should be rectified (within reason) if possible. 

**Monte Carlo Simulation**
* Speed Verification Criteria *
- Running Monte Carlo simulations should not exceed 120 seconds.
- The scatter plot should not take more than 60 seconds to pop up. 

* Easy of use, Efficiency & Learnability Verification Criteria *
- The process of running the simulations and plotting it should take less than 10 user clicks/actions. This is to ensure good user experience - the most important features of our program should be the most accessible.
- Before release, comprehensive instruction documentation needs to be created to help make the program easy to use and easy to learn.

* Functionality Verification Criteria *
- The program should be fit for purpose for 90% of the use cases specified in Section 3.2

The final Monte Carlo program needs to be verified against these criteria before the final release.

## 5. Development schedule.

### 5.1 Schedule

Identify dates for key project deliverables: 

1. architectural prototype
2. minimum viable product
3. further releases

| Project Deliverable Semester 1                          | Due Date  |
| ------------------------------------------------------- | --------- |
| First Performance Assessment                            | 20th May  |
| Minimum Viable Product                                  | 15th June |
| Product Satisfying All Features Outlined in the Handout | 20th June |
| Architecture Completed                                  | 20th June |
| Project Requirements Completed                          | 20th June |
| Second Performance Assessment                           | 21st June |
| Test                                                    | 26st June |

| Project Deliverable Semester 1 | Due Date |
| ------------------------------ | -------- |
| First Performance Assessment   | 7/8      |
| Second Performance Assessment  | 18/9     |
| Third Performance Assessment   | 16/10    |
| Presentation                   | 22/10    |

### 5.2 Budget

Present a budget for the project (table), and justify each budget item (one paragraph per item, one page overall). 

Since our project is only based on software, we don’t necessarily need a budget because all of the resources that we need to complete the project are free. I assume that this section would be for the hardware teams who need a budget for physical components.

### 5.3 Risks 

Identify the ten most important project risks to achieving project goals: their type, likelihood, impact, and mitigation strategies (3 pages).
If the project will involve any work outside the ECS laboratories, i.e. off-campus activities, these should be included in the following section.

| Risk                   | Type   | Likelihood | Impact                                 | Mitigation                                           |
| ---------------------- | ------ | ---------- | -------------------------------------- | ---------------------------------------------------- |
| Eye Strain             | Health | Low        | Decrease Productivity                  | Regular Breaks                                       |
| Back Pain              | Health | Moderate   | Decrease Productivity/Potential Injury | Regular Breaks                                       |
| Carpal Tunnel Syndrome | Health | Very Low   | Serious long term injury               | Regular Breaks                                       |
| Vitamin D deficiency   | Health | Low        | Illness                                | Get Sun Exposure                                     |
| Stress                 | Mental | Moderate   | Burnout on project work                | Regular Breaks and good work life balence            |
| Sleep deprevation      | Health | Moderate   | Decrease Productivity                  | Finishing project work at a reasonable time each day |


### 5.4 Health and Safety

1. How teams will manage computer-related risks such as Occupational Over Use, Cable management, etc. 

Make sure that each member of our team is maintaining a good work life balence in regard to the project in order to minimise isseus like neck pain, eye strain, burn out, etc. Also while working making sure each team member takes regular breaks to remain in good health.

2. Whether project work requires work or testing at any external (off-campus) workplaces/sites. If so, state the team's plans for receiving a Health and Safety induction for the external workplaces/sites. If the team has already received such an induction, state the date it was received. 

Within this software project no on site work is required meaning the no induction will be necisarry.

3. Whether project work requires the team test with human or animal subjects? If so, explain why there is no option but for the team to perform this testing, and state the team's plans for receiving Ethics Approval _prior_ to testing.

Within this project we are not working with any animals meaning there is no comment necessary.


#### 5.4.1 Safety Plans

In order to maintaine health and safety of the members of our team we will promote the idea of moderation. This means that there is no expectation to work long hours in a row with no breaks but rather to spread the workload out evenly. This will prevent the risks of eye strain, back pain, and carpal tunnel syndrome. Additionally to this we follow the recommendation of taking breaks outside in order to get the recommended amount of vitamin D in a day.


## 6. Appendices

### 6.1 Assumptions and dependencies 

Likely the most important assumption for our project is the assumption that we will be using the java programming language to write our software. Since java is a cross platform language, this removes the dependency of a specific operating system for our software product. Open Rocket is also written in Java so it would be much easier to use the code from this program if we used the same language.

Assuming that we will be using the most up to date version of open rocket for our program.

Another assumption is that our program will be developed separately to open rocket as a plugin, with its own GUI and source code. We will interact with some code from the Open Rocket program in our own program to get all the functionality we need.

The most important dependency for us as a software development project would be the Open Rocket program. Both our Monte Carlo and PID Controller tasks require Open Rocket for us to extend or use as a reference. During our development process we will very often be looking at the source code of Open Rocket for us to use in our own program.


### 6.2 Acronyms and abbreviations

Currently No acronyms or abbreviations in our document.

## 7. Contributions

A one page statement of contributions, including a list of each member of the group and what they contributed to this document.

Done section Client and Purpose in section 1 - 7th of may - Isaac Irvine, Joshua Richards, Justine Lim-Ranola

Worked on some use cases (Section 3.2) - 20th May - Justine Lim-Ranola, Joshua Richards, Pragya Pradhan, Jacob Fraser
Worked on section 3.5 - 20th May - Justine Lim-Ranola, Joshua Richards, Pragya Pradhan, Jacob Fraser

Updated on Non-functional requirement (section 3.7)-21/05/2020 - Pragya Pradhan, Justine Lim-Ranola

Update Safety Plans (section 5.4.1) - 19/06/2020 - Justine Lim-Ranola

Update Sections 3.1 and 3.8 - 21/07/2020 - Justine Lim-Ranola

Adding use cases and health, assumptions, semester 2 schedule and safety information - 6/8/20 - Josh Richards

Update Sections 4- 5/10/2020 - Justine Lim-Ranola

Update Sections 3.4 - 16/10/2020 - Justine Lim-Ranola


## Formatting Rules 

 * Write your document using [Markdown](https://gitlab.ecs.vuw.ac.nz/help/user/markdown#gitlab-flavored-markdown-gfm) and ensure you commit your work to your team's GitLab repository.
 * Major sections should be separated by a horizontal rule.


## Assessment  

The goal of a requirements document is the problem you are attempting to solve:  not a first attempt at a solution to that problem. The most important factor in the assessmernt of the document is how will it meet that goal. The document will be assessed for both presentation and content. 

The presentation will be based on how easy it is to read, correct spelling, grammar, punctuation, clear diagrams, and so on.

The content will be assessed according to its clarity, consistency, relevance, critical engagement and a demonstrated understanding of the material in the course. We look for evidence these traits are represented and assess the level of performance against these traits. While being comprehensive and easy to understand, this document must be reasonably concise too. You will be affected negatively by writing a report with too many pages (far more than what has been suggested for each section above).

We aim to evaluate ENGR301 documents and projects as if they were real projects rather than academic exercises &mdash; especially as they are real projects with real clients. The best way to get a good mark in a document is to do the right thing for your project, your client, and your team. We encourage you to raise questions with your tutor or course staff, as soon as possible, so you can incorporate their feedback into your work.