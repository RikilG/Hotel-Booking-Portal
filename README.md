# Hotel Booking Portal
A complete hotel booking portal written in Java using Object Oriented Programming.
 - IDE used: Eclipse
 - Libraries used:
   - Java awt
   - Java swing
   - Jcalendar

All information regarding hotels and users is stored in csv format

## Project Tree showing file structure and details
```sh
Project Root
├── HotelBookingPortal
│   ├── files
│   │   ├── bookingsDB.csv              # stores all bookings done by the client
│   │   ├── hotelsDB                    # all images and hotels corresponding to cities are available here (csv format)
│   │   │   ├── ahmedabad.csv
│   │   │   ├── bengaluru.csv
│   │   │   ├── chennai.csv
│   │   │   ├── delhi.csv
│   │   │   ├── hotelFormatExample.csv
│   │   │   ├── hyderabad.csv
│   │   │   ├── mumbai.csv
│   │   ├── user_database.csv           # all the registered users info is stored here
│   │   └── waitinglist.csv             # waiting list for clients who want a occupied hotel suite
│   ├── img                             # contains icons required by the application
│   ├── jcalendar-1.4.jar               # claendar library to select dates
│   └── src                             # source code for main java application
│       ├── dbManagers                  # classes which expose function for database management
│       │   ├── BookingDbManager.java
│       │   ├── CustomerDbManager.java
│       │   └── HotelDbManager.java
│       ├── definitions                 # Objects used in java application
│       │   ├── Customer.java
│       │   ├── EnvironmentVariables.java
│       │   ├── HotelCard.java
│       │   ├── Hotel.java
│       │   └── UserRequirements.java
│       └── portal                      # main UI of the application using awt and swing
│           ├── DestinationsUI.java
│           ├── Entrance.java
│           ├── HotelBookingUI.java
│           ├── HotelListUI.java
│           ├── LoginUI.java
│           ├── Main.java
│           ├── ModifyHotelUI.java
│           ├── ProfileUI.java
│           ├── RegisterUI.java
│           └── SpecificHotelUI.java
├── LICENSE                             # Project licensed under MIT
└── README.md                           # This file
```