# 🌍 Global City Population Analysis

A **Java-based Data Structures project** that analyzes global city population data using **custom implementations of Linked Lists and Stacks**.

The program reads **city population data from a CSV dataset**, organizes cities by continent, and performs multiple analytical operations such as:

- 📉 Detecting shrinking cities  
- 📊 Calculating population growth rates  
- 🏙 Finding middle cities in stacks  
- 🌎 Identifying the continent with the lowest population  

This project demonstrates how **core data structures can be applied to real-world datasets.**

---

# 🚀 Features

## 📉 Shrinking Cities Detection

Identifies cities where the population **decreased from 2023 to 2024**.

**Condition used:**

```
population2024 < population2023
```

Cities are displayed **continent-wise**.

---

## 🌎 Continent Population Analysis

The program calculates the **total population of each continent** and determines the **continent with the lowest population**.

This is implemented using a custom **PopulationStack data structure.**

---

## 📊 Population Growth Rate Analysis

The growth rate of each city is calculated using:

```
Growth Rate = (Population2024 - Population2023) / Population2023 × 100
```

The system identifies:

- 📈 **City with the highest growth rate**
- 📉 **City with the lowest growth rate**

---

## 🏙 Middle City Finder

Cities from each continent are stored in **stacks**.

The program determines the **middle city in each continent stack** using stack operations.

---

# 🧠 Data Structures Implemented

This project intentionally **avoids Java's built-in collections** to demonstrate **manual implementation of data structures.**

---

## Linked List

Cities are stored in **sorted linked lists** based on **2024 population (descending).**

Example:

```
Asia LinkedList
City → City → City → City
```

Each node represents a **City object** containing:

```
City
 ├── name
 ├── continent
 ├── population2024
 ├── population2023
 └── next
```

---

## Stack

Each continent also maintains its **own stack of cities**.

```
AsiaStack
EuropeStack
AfricaStack
NorthAmericaStack
SouthAmericaStack
OceaniaStack
```

Stacks are used for operations such as **finding the middle city.**

---

## Population Stack

A specialized stack that stores:

- **Continent Name**
- **Total Population**

This structure allows efficient identification of the **continent with the lowest population.**

---

# 📊 Dataset Format

The program reads data from a **CSV file.**

Example dataset:

```
City,Country,Continent,Population2024,Population2023
Tokyo,Japan,Asia,37400068,37300068
Delhi,India,Asia,33100000,32900000
Shanghai,China,Asia,29900000,29800000
Sao Paulo,Brazil,South America,22600000,22400000
Cairo,Egypt,Africa,22100000,21900000
```

## Dataset Fields

| Column | Description |
|------|-------------|
| City | Name of the city |
| Country | Country of the city |
| Continent | Continent where the city is located |
| Population2024 | Population in 2024 |
| Population2023 | Population in 2023 |

---

# ⚙️ Program Workflow

```
CSV Dataset
     │
     ▼
File Reader (BufferedReader)
     │
     ▼
Create City Objects
     │
     ▼
Insert into Continent LinkedLists
     │
     ▼
Convert Lists → Stacks
     │
     ▼
Perform Population Analysis
```

---

# 🖥 Program Menu

When the program runs, the user can select from the following options:

```
1. List shrinking cities
2. Find continent with the lowest population
3. Find middle cities in each continent stack
4. Find city with highest and lowest growth rates
5. Exit
```

---

# 📁 Project Structure

```
city-population-analysis
│
├── src
│   ├── Main.java
│   ├── City.java
│   ├── LinkedList.java
│   ├── Stack.java
│   └── PopulationStack.java
│
├── data
│   └── DatasetUpdated.csv
│
├── docs
│   └── output-screenshot.png
│
├── README.md
└── .gitignore
```

---

# 🛠 Technologies Used

- Java  
- Custom Linked Lists  
- Custom Stacks  
- File Handling  
- CSV Data Processing  
- Console-based User Interface  

---

# ⏱ Algorithm Complexity

| Operation | Data Structure | Time Complexity |
|----------|---------------|----------------|
| Insert city | Linked List | O(n) |
| Push city | Stack | O(1) |
| Pop city | Stack | O(1) |
| Population analysis | Traversal | O(n) |
| Growth rate calculation | Traversal | O(n) |

---

# ▶️ How to Run

### 1️⃣ Clone the repository

```bash
git clone https://github.com/yourusername/city-population-analysis.git
```

### 2️⃣ Navigate to the project directory

```bash
cd city-population-analysis
```

### 3️⃣ Compile the source code

```bash
javac src/*.java
```

### 4️⃣ Run the program

```bash
java -cp src Main
```

---

# 📷 Example Output

```
Select an option:
1. List shrinking cities
2. Find continent with the lowest population
3. Find middle cities in each continent stack
4. Find city with highest and lowest growth rates
5. Exit
```

---

# 🎯 Learning Outcomes

This project demonstrates:

- Implementation of **Linked Lists from scratch**
- Implementation of **Stacks using node structures**
- **Sorting within linked lists**
- **CSV file processing in Java**
- Application of **data structures to real-world datasets**

---

# 👨‍💻 Author

**Abdul Basit**  
Software Engineering Student  
Mehran University of Engineering & Technology

### Interests

- Artificial Intelligence  
- Data Science  
- Software Engineering
