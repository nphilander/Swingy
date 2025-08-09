# 🎮 Swingy: A Java RPG Adventure
*A minimalist, flexible RPG where heroes battle villains—playable in **GUI** or **CLI**, with seamless switching!*

Built with **MVC architecture**, **Maven**, **Hibernate validation**, and **MySQL persistence**.

![Java](https://img.shields.io/badge/Java-8-blue)  
![Maven](https://img.shields.io/badge/Build-Maven%203.9+-green)  
![MySQL](https://img.shields.io/badge/DB-MySQL-orange)

---

## ✨ Features
- **Dual Interface**: Switch between **GUI** and **CLI** mid-game!
- **Hero Classes**: Choose between **Swordsman** or **Archer**, each with unique stats.
- **Dynamic Maps**: Procedurally generated based on hero level.
- **Epic Battles**: Fight villains or risk fleeing-50% chance to escape!
- **Artifacts**: Collect weapons, armor, and helms to boost stats.
- **Persistent Progress**: Save heroes and game states to **MySQL**.

---
## ✨ Key Updates (2025)
- **Upgraded Dependencies**:
    - Hibernate Validator `6.2.5.Final` (Bean Validation 2.0)
    - JUnit `4.13.2` for stable testing
    - Jakarta EL `4.0.2` (replaced deprecated `javax.el`)
___

- **Java 8 Required**:
  ```xml
  <maven.compiler.source>1.8</maven.compiler.source>
  <maven.compiler.target>1.8</maven.compiler.target>
  ```
___
- **System Requirements**:
  - Java 8 JDK(Not JRE)
  - Maven 3.9+
  - MySQL 5.7+(for game state persistence)
___

## 🚀 Quick Start Guide
### Clone & Build
  ```sh
  git clone https://github.com/your-repo/swingy.git
   cd swingy
   mvn clean package
  ```

### Run the Game
#### Command Line Mode:
```sh
   java -jar target/swingy-1-jar-with-dependencies.jar console
   ```

#### Graphical Mode:

```sh
   java -jar target/swingy-1-jar-with-dependencies.jar gui
   ```
___
## 🎮 Gameplay Overview

### 🧙 Hero Selection
Choose between two unique hero classes:
- **Swordsman**: Balanced warrior
- **Archer**: Ranged specialist

**Starting Options**:
1. **Create New Hero**
2. **Load Existing Hero**

### 📊 Hero Stats Display
All heroes show:
| Attribute  | Description          |
|------------|----------------------|
| Name       | Hero's identifier    |
| Class      | Swordsman or Archer  |
| Level      | Current power tier   |
| Experience | Progress to next level |
| Attack     | Damage capability    |
| Defense    | Damage resistance    |
| Hit Points | Health capacity      |

### 🏆 Artifact System
Collectible items that enhance stats:
- **Weapon** (`⚔️`): Boosts Attack
- **Armor** (`🛡️`): Increases Defense
- **Helm** (`⛑️`): Augments Hit Points

---
### 🌍 World Navigation
Map Size Formula:
((level - 1) * 5) + 10 - (level % 2)
Example: Level 7 → 39×39 grid

#### Game Rules:

Start at map center

Win by reaching any border

#### Movement options:

| Direction | Icon |
|-----------|------|
| North     | ↑    |
| East      | →    |
| South     | ↓    |
| West      | ←    |
___

### ⚔️ Villain Encounters
When encountering enemies:

#### Fight

- Turn-based battle simulation

- Risk: Hero death = Game Over

#### Run (50% Success Chance)

- Successful: Return to previous position

- Failed: Forced combat

#### Victory Rewards:
``
Experience Points:
(level × 1000) + ((level − 1)² × 450)
``
Artifact Chance: Random drop (quality scales with villain strength)
___

### 📈 Level Progression
| Level | XP Required |
|-------|-------------|
| 1     | 1,000       |
| 2     | 2,450       |
| 3     | 4,800       |
| 4     | 8,050       |
| 5     | 12,200      |

___
## 🛠️ Technical Architecture
- MVC Pattern: Clean separation of concerns

- Hibernate Validation: Annotated input validation

- MySQL Integration: Automatic game state persistence

- Maven Build: Standardized project structure
