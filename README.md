# 🌎 YourTravelPartner

YourTravelPartner is a full-stack travel planning platform designed to help travelers discover destinations, plan personalized trips, understand travel requirements, and manage travel expenses in one place.

## ✈️ Project Vision

Planning a trip often requires using many different websites and applications for destinations, attractions, hotels, flights, itineraries, and expenses.

YourTravelPartner aims to bring these parts of travel planning together into one platform.

**Discover → Prepare → Plan → Travel → Track**

## ⭐ Planned Features

- Search countries and cities
- Discover popular attractions
- Explore local food and restaurants
- View destination information
- Check visa and entry requirements based on passport country
- Search hotels and transportation
- Create personal trips
- Build day-by-day itineraries
- Save favorite places
- Set travel budgets
- Track travel expenses
- View remaining budget

## 🛠 Tech Stack

### Backend
- Java
- Spring Boot
- Maven
- REST APIs

### Database
- PostgreSQL
- Spring Data JPA
- Hibernate

### Frontend
- React
- Next.js
- TypeScript

### Development Tools
- Git
- GitHub
- Visual Studio Code

---

# 🚀 Development Roadmap

## v0.1 — Backend Foundation ✅

**Status: Completed**

- [x] Create project repository
- [x] Configure Git and GitHub
- [x] Create Java Spring Boot backend
- [x] Configure Maven
- [x] Add Spring Web
- [x] Run backend server on localhost
- [x] Create first REST controller
- [x] Create first GET endpoint
- [x] Test endpoint using curl
- [x] Configure `.gitignore`
- [x] Commit and push backend to GitHub

### Current Endpoint

```http
GET /
```

Response:

```text
Welcome to YourTravelPartner!
```

---

## v0.2 — Database Foundation 🚧

**Goal:** Connect the Spring Boot backend to a real PostgreSQL database.

Planned work:

- [ ] Install and configure PostgreSQL
- [ ] Create `yourtravelpartner` database
- [ ] Connect Spring Boot to PostgreSQL
- [ ] Add Spring Data JPA
- [ ] Create `Country` entity
- [ ] Create `City` entity
- [ ] Create repositories
- [ ] Create service layer
- [ ] Create controllers
- [ ] Add sample country data
- [ ] Add sample city data
- [ ] Create country APIs
- [ ] Create city APIs
- [ ] Create city search
- [ ] Test database APIs
- [ ] Commit and push v0.2

### Planned Architecture

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
PostgreSQL
```

### Initial Data Model

```text
Country
   │
   └── City
```

Example:

```text
Japan
├── Tokyo
├── Kyoto
└── Osaka

United States
├── San Francisco
├── Los Angeles
└── New York

China
├── Shanghai
├── Beijing
└── Guangzhou
```

---

## v0.3 — Destination Discovery

**Goal:** Turn countries and cities into useful travel destinations.

Planned work:

- [ ] Create Attraction model
- [ ] Create Attraction repository
- [ ] Create Attraction service
- [ ] Create Attraction controller
- [ ] Create Food model
- [ ] Add local food information
- [ ] Add city travel information
- [ ] Add attraction search
- [ ] Filter attractions by category
- [ ] Create destination details API
- [ ] Add sample Tokyo data
- [ ] Add sample Paris data
- [ ] Add sample New York data
- [ ] Test destination APIs
- [ ] Commit and push v0.3

### Planned Data Model

```text
Country
   │
   └── City
        │
        ├── Attractions
        ├── Food
        └── Travel Information
```

---

# 🔮 Future Versions

## v0.4 — User Accounts & Traveler Profile

Planned features:

- User registration
- Login
- Traveler profile
- Nationality
- Passport country
- Country of residence
- Home / departure city

---

## v0.5 — Trips & Itinerary

Planned features:

- Create trips
- Add destinations to trips
- Save attractions
- Build day-by-day itineraries
- Add itinerary activities
- Upcoming and past trips

```text
User
 ↓
Trip
 ↓
Trip Destination
 ↓
Itinerary
 ↓
Itinerary Item
```

---

## v0.6 — Budget & Expenses

Planned features:

- Set trip budget
- Add expenses
- Expense categories
- Calculate total spending
- Calculate remaining budget
- View expense breakdown

```text
Trip
├── Budget
└── Expense
     └── Expense Category
```

---

## v0.7 — Frontend

Build the user interface with React / Next.js.

Planned pages:

- Home
- Explore
- Destination
- My Trips
- Trip Details
- Itinerary
- Expenses
- Saved Places
- Profile

---

## v0.8 — Full-Stack Integration

Connect:

```text
React / Next.js
       ↓
REST API
       ↓
Spring Boot
       ↓
PostgreSQL
```

---

## v0.9 — External Travel Data

Planned integrations may include:

- Maps and places
- Weather
- Currency and exchange rates
- Visa / entry information
- Hotels
- Flights
- Transportation

Travel and entry requirements should use reliable and current data sources rather than relying only on permanently stored information.

---

## v1.0 — First Production Release 🚀

Planned goals:

- Complete core travel workflow
- Testing
- Error handling
- Security review
- Responsive design
- Production database
- Backend deployment
- Frontend deployment
- Custom domain
- Public release

---

# 📌 Current Development Status

```text
v0.1  Backend Foundation       ✅ Completed
v0.2  Database Foundation      🚧 Next
v0.3  Destination Discovery    ⬜
v0.4  User Accounts            ⬜
v0.5  Trips & Itinerary        ⬜
v0.6  Budget & Expenses        ⬜
v0.7  Frontend                 ⬜
v0.8  Full-Stack Integration   ⬜
v0.9  External Travel APIs     ⬜
v1.0  Production Release       ⬜
```

## Current Backend Structure

```text
YourTravelPartner/
├── backend/
│   ├── src/main/java/com/yourtravelpartner/backend/
│   │   ├── BackendApplication.java
│   │   └── controller/
│   │       └── HomeController.java
│   ├── src/main/resources/
│   │   └── application.properties
│   ├── pom.xml
│   └── .gitignore
└── README.md
```

---

## 👩‍💻 Development

This project is being developed as a long-term personal project for learning and practicing full-stack software development, backend architecture, databases, REST APIs, frontend development, and real-world application design.
