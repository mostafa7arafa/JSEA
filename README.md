# JSEA

Jsea is a user-friendly application designed for booking sea trip tickets effortlessly. With Jsea, users can easily select their desired ticket options, including specific fleets and multiple time slots. Furthermore, passengers have the flexibility to choose their preferred route. Once all requirements are chosen, users can confirm their booking, generating a ticket along with the necessary bills. The ticket is conveniently available in PNG format, allowing for easy printing at any time. Additionally, Jsea features an Admin section that records comprehensive ticket information, providing administrators with detailed insights into all booking activities within the application.


# UML Diagram

![jsea](https://github.com/mostafa7arafa/JSEA/assets/58299212/0bc5674e-e698-4c4d-875a-584c9409175a)


## Classes demonstration 

**Passenger:** is a class that represents each passenger it inherits all features of person class, in addition to adding an instance variable for count of booking using the app for the special discount.

**Trip:** is a class that describe passengers’ trip as it contains both the route of the trip and the date.

**Bill:** is an interface that contain two important abstract methods which are Cacost for calculating the trip fees and Discount for determining the full cost of the trip after the discount.

**Tickets:** is the last stage class that most of the above classes to generate a ticket to the passengers, and prepare it to be ready for printing, it also updates the current Date text file with the new booking actions, Tickets class implements Bill interface for calculating the cost of the trip with and without the discount.

**HelloController:** is a controller class for both home screen and admin choice scenes.

**GuestController:** is a controller class for all guest scenes actions.

## Objectives of the project

-   Its main vision is to Improve the tourism in Egypt.
-   It will ease the process of booking tickets without any complications
-   It faster and easy to use
-   It will decrease the conflict of choosing unsuitable boat
-   It will give you an idea of places that can be visited in Red Sea, maybe it can change your mind.
-   It will offer all its users a special price
-   Any booking actions take place in the app will be recorded in a text file called current Data
-   Tickets are ready to be printed instantaneously
