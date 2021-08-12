# ENGR 301: Architectural Design and Proof-of-Concept

## Proof-of-Concept

The aim of an architectural proof-of-concept (spike or walking skeleton) is to demonstrate the technical feasibility of your chosen architecture, to mitigate technical and project risks, and to plan and validate your technical and team processes (e.g., build systems, story breakdown, Kanban boards, acceptance testing, deployment).

A walking skeleton is an initial technical attempt that will form the architectural foundation of your product. Since a walking skeleton is expected to be carried into your product, it must be completed to the quality standards expected for your final product. A walking skeleton should demonstrate all the technologies your program will rely on "end-to-end" &mdash; from the user interface down to the hardware.

In the context of ENGR 301, a walking skeleton does not need to deliver any business value to your project: the aim is technical validation and risk mitigation.


## Document

The aim of the architectural design document is to describe the architecture and high-level design of the system your group is to build, to identify any critical technical issues with your design, and to explain how you have addressed the highest rated technical and architectural risks. The architecture document should also demonstrate your understanding of architectural techniques and architectural quality, using tools and associated notations as necessary to communicate the architecture precisely, unambiguously and clearly in a written technical document.

Page specifications below are *limits not targets* and refer to the pages in the PDF generated from the markdown. Because the size of your document is necessarily limited, you should ensure that you focus your efforts on those architectural concerns that are most important to completing a successful system: if sections are at their page limit, indicate how many items would be expected in a complete specification.

The ENGR 301 project architecture design document should be based on the standard ISO/IEC/IEEE 42010:2011(E) _Systems and software engineering &mdash; Architecture description_, plus appropriate sections from ISO/IEC/IEEE 29148:2018(E) _Systems and software engineering &mdash; Life cycle processes &mdash; Requirements engineering_; ISO/IEC/IEEE 15289:2017 _Systems and software engineering &mdash; Content of life-cycle information items (documentation)_; ISO/IEC/IEEE 15288:2015 _Systems and software engineering &mdash; System life-cycle processes_; ISO/IEC/IEEE 12207:2017 _Systems and software engineering &mdash; Software life cycle processes_ and ISO 25010 SQuaRE; with notations from ISO/ISE 19501 (UML). In particular, Annex F of ISO/IEC/IEEE 15288 and Annex F of ISO/IEC/IEEE 12207. These standards are available through the Victoria University Library subscription to the [IEEE Xplore Digital Library](https://ieeexplore.ieee.org/) (e.g., by visiting IEEE Xplore from a computer connected to the University network).

The document should contain the sections listed below, and conform to the formatting rules listed at the end of this brief.

All team members are expected to contribute equally to the document and list their contributions in the last section of the document (please make sure that your continued contribution to this document can be traced in GitLab). You should work on your document in your team's GitLab repository in a directory called "M2_Architecture". If more than one team member has contributed to a particular commit, all those team member IDs should be included in the first line of the git commit message. ``git blame``, ``git diff``, file histories, etc. will be tools used to assess individual contributions, so everyone is encouraged to contribute individually (your contribution should be made to many sections of the document, rather than focusing on just a single section), commit early and commit often.

---

# ENGR 301 Project *NN* Architectural Design and Proof-of-Concept

**Authors:** Justine Lim-Ranola, Pragya Pradhan, Jaynesh	Patel, Joshua Richards, Jacob	Fraser, Alakai	Chapman,Isaac Irvine

## 1. Introduction

### Client

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


## 2. References

References to other documents or standards. Follow the IEEE Citation Reference scheme, available from the [IEEE website](https://ieee-dataport.org/sites/default/files/analysis/27/IEEE%20Citation%20Guidelines.pdf) (PDF; 20 KB). (1 page, longer if required)

## 3. Architecture

Describe your system's architecture according to ISO/IEC/IEEE 42010:2011(E), ISO/IEC/IEEE 12207, ISO/IEC/IEEE 15289 and ISO/IEC/IEEE 15288.

Note in particular the note to clause 5 of 42010:

_"The verb include when used in Clause 5 indicates that either the information is present in the architecture description or reference to that information is provided therein."_

This means that you should refer to information (e.g. risks, requirements, models) in this or other documents rather than repeat information.

### 3.1 Stakeholders

See ISO/IEC/IEEE 42010 clause 5.3 and ISO/IEC/IEEE 12207 clause 6.4.4.3(2).

For most systems this will be about 2 pages, including a table mapping concerns to stakeholder.


### 3.2 Architectural Viewpoints

##### Logical 

The logical viewpoint communicates the functionality of the system it provides to the end-users. This is done by compartmentalising the system into its key concepts, which are then represented using class and state diagrams.

##### Development 

The development viewpoint communicates the architecture which supports the processes involved during the software development cycle. In particular, this is aimed at addressing concerns regarding the management of the software.

##### Process 

The process viewpoint communicates the dynamic as well as non-functional requirements of the system. An example would be the availability and performance, aswell ass how the main abstractions drawn from the logical viewpoint fit within the process architecture.

##### Physical

The physical viewpoint communicates the relationship between the software and the given hardware infrastructure. More specifically, the physical viewpoints describes the availability, reliability, performance, and scalability of the system as a whole.

##### Circuit Architecture

The circuit architecture viewpoint communicates how the physical system is assembled while also addressing the construction and physical processes which may interfere with the physical system.

##### Hardware Architecture

The hardware viewpoint communicates the purpose and effects by which the software and hardware systems interact at a fundamental level. More specifically, the hardware viewpoint is primarily concerned with how the hardware enables the overall system to function as intended.

##### Scenario

The scenario viewpoint communicates the specific use-cases which describe the interactions between end-users or processes. This is further used as a qualatative review of the respective system architectures and allows the formation of test-cases.

### 4. Architectural Views

(5 sub-sections of 2 pages each sub-section, per 42010, 5.5, 5.6, with reference to Annex F of both 12207 and 15288) 

Describe your system's architecture in a series of architectural views, each view corresponding to one viewpoint.

You should include views from the following viewpoints (from Kruchten's 4+1 model):

 * Logical
 * Development
 * Process
 * Physical 
 * Scenarios - present scenarios illustrating how two of your most important use cases are supported by your architecture

As appropriate you should include the following viewpoints:

 * Circuit Architecture
 * Hardware Architecture

Each architectural view should include at least one architectural model. If architectural models are shared across views, refer back to the first occurrence of that model in your document, rather than including a separate section for the architectural models.

### 4.1 Logical
The logical viewpoints contain the structural, computational, communicational, and behavioural responsibilities of the software (logical) component of the system architecture. For this viewpoint the logical system used to describe and diagram the logical viewpoint follows the notation of the Unified Modeling Language (UML). 
##### UML Diagram
![UML Diagram](project_requirement/screencap.PNG)


 Throughout this UML diagram the logical relations are outlined: These include assosciation, inheritance, usage and many more inetrdisciplinary relationships between the logical architure. Classes are essentialy sets of functions grouped into specific categories which emphasise specific operations. These classes also include object identifiers and outline their primary characteristics and parameters and are outlined below.

 ##### MonteCarlo.java
- getName() : Returns the name of the plugin. 
- getDescription() : Returns a small description outlining the function of the plugin.
- initialize() : Adds a simulation listener to the currently running simulation / simulations.
 ##### MonteCarloConfigurator.java
 - Provides a JComponent by which the default parameters used by the simulator can instead be input by the user. For example the user can define the launch angle deviation or wind deviation to be used in the simulator which can then be used when the simulations are run as a parameter.
 ##### MonteCarloProvider
 - Provides labels for the components within the plugin when used in openRocket. 
 ##### MonteCarloSimulationListener
 - The MonteCarloSimulationListener class is a component by which the user can parse values through the MonteCarloConfigurator class. These values include the number of simulations to be ran (for example 100) as well as the launchAngle, launchDirection and windVariation.
 - startSimulation() : Is a method which runs the simulation with user configured parameter values. Throughout every new iteration there is a slight level of randomisation applied to every parameter, this is used in order to provide a degree of variance in the final output at every iteration of the simulation.
 ##### EndSimListener
 - endSimulation() : A method which writes the x and y landing co-ordinates of the current simulation to a .txt file. This file is then read once all defined simulations have executed and their unique co-ordinated recorded. This output is used to create the visual aspect of the landing positions in the final product. 
 ##### MonteCarloLegacy 
 - The MonteCarloLegacy class is responsible for providing the final visulatisation component of the plugin. By taking the compiled outputs of the simulations, the final positions can undergo data transformation to produce a visual representation. There is a maven dependency used which provides a more user friendly experience. 
 - parseData() : A method which parses data from the .txt file generated and organised the information into Double arrays.
 - plot() : A method which takes the x and y co-ordinates and generated a scatter plot within the JFrame. 
 - calculatedSD() : A method which calculates the standard deviation of the accumulative array values.
 - printToFile() : A method which outputs the standard deviation values to a csv text file

### 4.2 Development
The majority of the custom code developed by the team is within the monte_carlo_extension/src/main/java/net/sf/openrocket/montecarloextension folder. It contains the java files that make up the OpenRocket plugin. These files include:
- MonteCarlo: Has the name of the plugin, description of the plugin and adds the plugin to the given simulation.
- MonteCarloConfigurator: Contains the Swing code that is displayed when the plugin is added to a simulation. It gives the user the ability to customise the functionality of the plugin.
- MonteCarloProvider: Simply sets the labels for the plugin when it is shown in the list of plugins in OpenRocket.
- MonteCarloSimulationListener: Contains the main functionality of the plugin. It has a listener that monitors when the simulation begins. Upon the beginning of the simulation the plugin will run a for loop with 'x' amount of iterations. In each iteration it creates a copy of the simulation, changes some of its parameters, adds the EndSimListener to it and then runs the simulation.
- EndSimListener: This file is used to listen to the end of a simulation that is being run within MonteCarloSimulationListener. Once the end of the simulation is detected, a method will fire that prints the location of the rocket (the landing position) to a data file. The file will be read once all simulations are run for visualisation purposes
- MonteCarloLegacy: Within this file is all of the data visualisation functionality of the plugin. Once all of the simulations have run the contructor of this class is called. This will process the data file produced from the simulations landing points and will then display a scatter plot of all of these data points. It uses a Maven library for the data visualisation in order to give a more stable and visaully appealing user experience.

### 4.3 Process

The process viewpoint is responsible for identifying all the individual processes interacting together to achieve the desired product. During this stage every individual process represents an object in the architecture responsible for controlling the starting, recovery, reconfiguration and shutting down of the entire system. In addition to this, processes are also replicable in cases where increased load distribution is required, or in the situation where availability is limited and needs to be improved. This is very useful when used with concurrency and parallelism, where thread pools are utilisable to help distribute heavy load tasks where processes may fork or join.

The concurrency present in this system can be assosciated with the reading of the data used in running the Monte-carlo simulation. Concurrency is utilisable due to the fact that the simulation must be repeatedly in order to produce the final result. Reading the data is done by using the input simulation parameters as well as the PID controller outputs. The process view follows the notation of our UML diagram below. 
##### UML Diagram
![UML Diagram](project_requirement/screencap.PNG)



### 4.4 Physical 
Due to the fact that it is a software project there isn't a need for physical view points. All that is required for this application to run is a computer with the latest version of OpenRocket installed on it.

### 4.5 Scenarios
...

## 5. Development Schedule

For each subsection, make clear what (if anything) has changed from the requirements document._ If unchanged, these sections should be copied over from the requirements document, not simply cross-referenced.

Schedules must be justified and supported by evidences; they must be either direct client requirements or direct consequences of client requirements. If the requirements document did not contain justifications or supporting evidences, then both must be provided here.

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

### 5.2 Budget and Procurement

#### 5.2.1 Budget

Since our project is only based on software, we don’t necessarily need a budget because all of the resources that we need to complete the project are free. We assume that this section would be for the hardware teams who need a budget for physical components. Should any extra software be required to work on this project, free, open source softwares will be used.


#### 5.2.2 Procurement

The main piece of software that we are using is OpenRocket. This program simulates rocket launches, where the rocket will land, and using this program will be essential for our Monte Carlo simulation and PID controller. This is an open source software so procurement on the internet is simple. This program will need to interface with our developed program so that we can get the data for our simulations

We will also be using programming IDEs to program in java. Either Eclipse or intellij. We need these IDEs to write and run the program that we develop. These can be easily procured from the internet for free. 

| Goods | Procurement | Purpose |
| ------ | ------ | ------ |
| JMathPlot | Maven dependency, Github open source plugin| This will visually plot the points for Monte Carlo simulation |

### 5.3 Risks 

Risk assessment scale used:

| Improbable | Possible | Probable |   
|------------|----------|----------|
| Risk is unlikely to occur | Risk is likely to occur | Risk is highly likely to occur |

Impact assessment scale used:

| Impact | Description |
|--------|-------------|
| Severe | A catostrophic disruption to the project or its participants which is unrecoverable or too expensive to justify repair |
| Significant | A major disruption to project operations or its participants which is recoverable but expensive  |
| Moderate | A manageble disruption to project operations or its participants which is recoverable and manageable at a moderate cost |
| Minor | A noticable disruption to project operations or its participants which is easily recoverable and inexpensive to manage |
| Insignificant | An insignificant disruption to project operations or its participants which does not need intervention

| Risk | Category | Likelihood | Impact | Mitigation |
|------|----------|------------|--------|------------|
| Course deadlines preventing one or more members from contributing during lab time or to the overall project | Management | Probable | Moderate | Conflicting schedules with other courses, for examples lectures during allocated lab times or large amounts of built up work during a specific week should properly be communicated with the team as a whole. This will allow adequate time for team members to allocate work in order to offset the work load which could otherwise effect the groups progression. This risk is likely unavoidable as all members take a wide variety of courses and electives. |
| Personal conflict which effects an individual to the point they cannot participate during allocated lab times or to the overall project | Management | Probable | Moderate/Significant | Personal issues which arise are likely sudden and could be detrimental toward individual participation. Issues which arise of this nature should be properly communicated to the group if they are of moderate severity, for example a form of sickness which temporarily hinders productivity, or a commitment for sports or other event. Personal issues of a more severe nature, such as a death in the family should be properly communicated to the Course Co-Ordinator Aaron Chen so the appropriate measures could be undertaken with respect to the situation. | 
| Low levels of productivity as a result of either improper task allocations, or by underestimating the workload to be undertaken | Management | Probable |Significant | In order to mitigate low levels of productivity, regular check ups should be maintained within the group outside of the allocated lab times and tutor meetings. By meeting more frequently during the length of sprints, regular discussions between group members can be held which determine the whereabouts of individuals in terms of their allocated tasks. If individuals are struggling, help can be re-allocated if there are team members available. Similarly, if tasks are consistently finished early, the nature of the task may be reassessed and there may be less prioritiy placed on that specific task so that the tasks which do require more attention are seen to. | 
| Physical injury or harm to a personals wellbeing caused by working on this project in an unsafe manner | Health & Safety | Probable | Significant | Individuals should maintain their physical wellbeing whilst working on this project. This can be done by ensuring proper levels of nutrition are upheld, by regularly consuming food and water the risk of dehydration of malnutrition are drastically lowered. Sleep should also be a regular occurance, as irregular sleeping patterns can cause cognitive decline, impairing an individuals ability to focus aswell as increasing levels of stress. In the same thought process breaks should be taken when working on this project for extended periods of time, regular breaks allow the aforementioned mitigation techniques to be executed, providing an opportunity to rehydrate and eat or take a step outside to ensure proper levels of vitamin D are attained during the day which can help alleviate stress. RSI (Repettitive Strain Injuries) can be avoided also by taking regular breaks and allowing the eyes and hands to rest for a period of time. Ultimately, "binging" should be avoided whilst working on this project, and proper health care routines should be prioritised when working for extended periods of time. | 
| Hardware failure | Hardware | Possible | Significant | Hardware failure such as a personal laptop dying is the only issue which requires mitigation. This is due to the nature of the project - being entirely software based otherwised. In the even of a personal instrument failing, work will be halted until repairs are conducted or an adequate substitute is found. In the event that a laptop dies and the individual is in Wellington, then lab PC's can be used so long as proper health and safety guidelines are followed while on univeraity grounds. In the event that hardware failure occurs and the effected individual is based from home (outside the Wellington region) time of repairs and severity will be unique to the situation. There is potential the individual cannot: Afford to repair their instrument, have requested repairs however there is a significant delay in time, or there is a deadline which can no longer be met due to the timing of the incident. Individuals should have a plan in place incase this situation arises, such as having the ability to use a spare laptop, or use a friends wi-fi network if their router were to die.
| Software failure | Software | Probable | Moderate/Significant | Software failure due to bugs or improper implementation to the source code are likely to occur. Due to the large scale of the project, it should be expected that code will need to be debugged as well as proofreaad through the process. Debugging is a good process to follow as it allows potentially program-crashing software errors to be identified and removed from source code. Proofreading code allows the group to ensure the logical performance of the code adheres to the project requirements. There is the potential for incorrect methods to be called, or for data outputs to be constructed from the wrong input data. These software bugs must be identified and removed at every state as moving on without spotting certain bugs could could potentially devestating behaviour at later stages of the code. A good way to debug code is to use print statements during method calls, this ensures that the expected inputs and outputs are present. If they aren't, then bugs can be easily identified and the logical flaw can be traced. | 
| Human error | All categories | Probable | Dependent on the situation | Human error is likely to occur during every step of the project and will likely be the most common risk to effect productivity. A potentially devestating human error could occur if an individual were to push a branch to master which caused the master to become corrupt and behave improperly. In order to minimise the effect of human error, all of the aforementioned procedures should be followed intently. Because all of the code is written by the team members, there will definitely be errors in the logical programming of the project. By ensuring proper physical health and well being is maintained, a focused mind can be used by members of the team to ensure they follow the other procedures. This helps to ensure proper code practices are followed, such as proofreading and debugging code. |
| Issues arising from Software cross-compatability or patches |  Software | Probable | Moderate | Software incompatability is likely to occur with such a project that relies on extending a pre-existing program. This can be mitigated however by ensuring either the most up to date versions of all the programs used are installed, such as having the most recent JDK installed or version of OpenRocket. Researching compability prior to any installation can also be used as a mitigation technique, by researching what specific versions of each software are compatible with the other applications, a steady platform can be built by utilising patches that are guaranteed to work together. | 
| Changes in the project requirements which deviate from the pre-determined plan of production | Management | Probable | Depenndent on the situation | Changes in the project requirement will likely occur during the development of the project. Due to being such a large scale project that is primarily software based, it is likely that a new level of education and understanding will be needed to complete the process. This learning will in turn change the outlook and scope of the project, likely involving new methods of implementation and ways of solving issues which were not initially thought of. In order to mitigate the effect of these constant changes on the overall project, these new understandings should be discussed during the regularly allocated meet up times. By ensuring proper communication occurs between team members, any changes in one section can allow othe members to implement the new understanding into their own section. An example would be one individual adding a new parameter in one section, for example "take off angle" to allow extra flexibility in the programs performance, and this individual being required to inform another individual that they must now account for the new parameter and its effect on the program. |
| Low stakeholder / customer interaction which results in a program that does not meet the requirementa of the end-user | Management | Possible | Significant | Failing to meet with the customer frequently to keep them updated on the progress of the project could result in large deviations from the intended product and the final product. Therefore, consistent communication between the software developers of the team should be maintained to ensure that if changes do occur to the initial plan, that they are still in line with what the customer would accept as a viable product. |

### 5.4 Health and Safety

1. How teams will manage computer-related risks such as Occupational Over Use, Cable management, etc. 

Make sure that each member of our team is maintaining a good work life balence in regard to the project in order to minimise isseus like neck pain, eye strain, burn out, etc. Also while working making sure each team member takes regular breaks to remain in good health.

2. Whether project work requires work or testing at any external (off-campus) workplaces/sites. If so, state the team's plans for receiving a Health and Safety induction for the external workplaces/sites. If the team has already received such an induction, state the date it was received. 

Within this software project no on site work is required meaning the no induction will be necisarry.

3. Whether project work requires the team test with human or animal subjects? If so, explain why there is no option but for the team to perform this testing, and state the team's plans for receiving Ethics Approval _prior_ to testing.

Within this project we are not working with any animals meaning there is no comment necessary.


#### 5.4.1 Safety Plans

Project requirements do not involve risk of death, serious harm, harm or injury.


## 6. Appendices

### 6.1 Assumptions and dependencies 

Likely the most important assumption for our project is the assumption that we will be using the java programming language to write our software. Since java is a cross platform language, this removes the dependency of a specific operating system for our software product. Open Rocket is also written in Java so it would be much easier to use the code from this program if we used the same language.

Another assumption is that our program will be developed separately to open rocket, with its own GUI and source code. We will reuse some code from the Open Rocket program in our own program to get all the functionality we need.

The most important dependency for us as a software development project would be the Open Rocket program. Both our Monte Carlo and PID Controller tasks require Open Rocket for us to extend or use as a reference. During our development process we will very often be looking at the source code of Open Rocket for us to use in our own program.

### 6.2 Acronyms and abbreviations

One page glossary as required 

## 7. Contributions

An one page statement of contributions, including a list of each member of the group and what they contributed to this document.
##### Justine 
*  [5.2] Budget and Procurement
*  [5.4] Health & Safety
*  [5.1] Schedule

##### Alakai
* [3.2] Architectural Viewpoints
* [5.3] Risks
---

## Formatting Rules 

 * Write your document using [Markdown](https://gitlab.ecs.vuw.ac.nz/help/user/markdown#gitlab-flavored-markdown-gfm) in your team's GitLab repository.
 * Major sections should be separated by a horizontal rule.


## Assessment 

This document will be weighted at 20% on the architectural proof-of-concept(s), and 80% on the architecture design.

The proof-of-concept will be assessed for coverage (does it demonstrate all the technologies needed to build your project?) and quality (with an emphasis on simplicity, modularity, and modifiability).

The document will be assessed by considering both presentation and content. Group and individual group members will be assessed by identical criteria, the group mark for the finished PDF and the individual mark on the contributions visible through `git blame`, `git diff`, file histories, etc. 

The presentation will be based on how easy it is to read, correct spelling, grammar, punctuation, clear diagrams, and so on.

The content will be assessed according to its clarity, consistency, relevance, critical engagement and a demonstrated understanding of the material in the course. We look for evidence these traits are represented and assess the level of performance against these traits. Inspection of the GitLab Group is the essential form of assessing this document. While being comprehensive and easy to understand, this document must be reasonably concise too. You will be affected negatively by writing a report with too many pages (far more than what has been suggested for each section above).

---
