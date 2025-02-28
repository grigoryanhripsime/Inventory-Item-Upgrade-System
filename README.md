# Inventory Item Upgrade System

This project is a Java-based inventory management system that allows users to upgrade items within an inventory. It is built using Maven for dependency management and project build automation. The system provides a simple yet effective way to manage and upgrade items in an inventory, making it suitable for small to medium-sized applications.

## Table of Contents
- [About the Project](#about-the-project)
- [Why Use Maven?](#why-use-maven)
- [How to Compile](#how-to-compile)
  - [Compiling via Terminal](#compiling-via-terminal)
  - [Compiling via IDE](#compiling-via-ide)
- [How to Use](#how-to-use)

## About the Project

The **Inventory Item Upgrade System** is designed to manage and upgrade items in an inventory. It provides functionalities such as adding items, upgrading items, and viewing the current state of the inventory. 
The project is structured as a Maven project, which simplifies dependency management and builds processes.

### Key Features:
- **Add Items**: Add new items to the inventory.
- **Add Items from a file**: Add new items to the inventory from a specified file.
- **Add Random Items**: Add new items, which are randomly generated to the inventory.
- **Upgrade Items**: Upgrade existing items in the inventory.
- **View Inventory**: Display the current state of the inventory.

## Why Use Maven?

Maven is a powerful build automation tool used primarily for Java projects. It simplifies the build process by managing project dependencies, compiling source code, packaging compiled code into JAR files, and managing the entire lifecycle of the project. Here are some reasons to use Maven:

- **Dependency Management**: Maven automatically downloads and manages project dependencies from repositories.
- **Standardized Project Structure**: Maven enforces a standard directory structure, making it easier to understand and navigate the project.
- **Build Automation**: Maven automates the build process, reducing the need for manual intervention.
- **Plugins**: Maven supports a wide range of plugins for various tasks, such as compiling code, running tests, and generating documentation.

## How to Compile

### Compiling via Terminal

1. **Ensure Maven is Installed**: Make sure you have Maven installed on your system. You can check this by running:
   ```bash
   mvn -v
   ```
   If Maven is not installed, you can download it from the [official Maven website](https://maven.apache.org/).

2. **Navigate to the Project Directory**: Open your terminal and navigate to the root directory of the project where the `pom.xml` file is located.
   ```bash
   cd path/to/Inventory-Item-Upgrade-System
   ```

3. **Compile the Project**: Run the following command to compile the project:
   ```bash
   mvn compile
   ```
   This will compile the source code and place the compiled classes in the `target/classes` directory.

4. **Package the Project**: To package the project into a JAR file, run:
   ```bash
   mvn package
   ```
   This will create a JAR file in the `target` directory.

5. **Run the Project**: You can run the project using the following command:
   ```bash
   mvn exec:java -Dexec.mainClass="org.InventoryItemUpgradeSystem.Main" 
   ```
   If you wanto to specify the file where your inventory is, add at the end of this command ```bash -Dexec.args="src/main/resources/inv" ```, where src/main/resources/inv is the path to the file

### Compiling via IDE

1. **Import the Project**: Open your preferred IDE (e.g., IntelliJ IDEA, Eclipse) and import the project as a Maven project. This can usually be done by selecting the `pom.xml` file during the import process.

2. **Build the Project**: Once the project is imported, you can build it using the IDE's built-in Maven support. Typically, this involves right-clicking on the project and selecting "Build" or "Reuild Project."

3. **Run the Project**: To run the project, locate the main class (usually found in `src/main/java`) and run it using the IDE's run configuration.

## How to Use

When you runn the project, it welcomes you and suggests options to usage:
```java
Welcome to our Iventory Item Upgrading system!
-----------------------------------------------------------------
Here are some options, for choosing one of them just enter the number!
1 - display inventory
2 - add an item to the inventory
3 - add an random item to the inventory
4 - fill the inventory from file
5 - upgrade the item
6 - exit
-----------------------------------------------------------------
Enter your choice:
```
You need to enter wanted option.


### Example Usage
```java
Welcome to our Iventory Item Upgrading system!
-----------------------------------------------------------------
Here are some options, for choosing one of them just enter the number!
1 - display inventory
2 - add an item to the inventory
3 - add an random item to the inventory
4 - fill the inventory from file
5 - upgrade the item
6 - exit
-----------------------------------------------------------------
Enter your choice: 1
Your inventory is empty!
-----------------------------------------------------------------
Here are some options, for choosing one of them just enter the number!
1 - display inventory
2 - add an item to the inventory
3 - add an random item to the inventory
4 - fill the inventory from file
5 - upgrade the item
6 - exit
-----------------------------------------------------------------
Enter your choice: 3
-----------------------------------------------------------------
Here are some options, for choosing one of them just enter the number!
1 - display inventory
2 - add an item to the inventory
3 - add an random item to the inventory
4 - fill the inventory from file
5 - upgrade the item
6 - exit
-----------------------------------------------------------------
Enter your choice: 4
Enter file path: src/main/resources/inv
-----------------------------------------------------------------
Here are some options, for choosing one of them just enter the number!
1 - display inventory
2 - add an item to the inventory
3 - add an random item to the inventory
4 - fill the inventory from file
5 - upgrade the item
6 - exit
-----------------------------------------------------------------
Enter your choice: 1
In your inventory you have: 
1 Iron Swords with Rare rarity!
3 Iron Swords with Epic rarity and 0 upgrade count!
3 Iron Swords with Common rarity!
-----------------------------------------------------------------
Here are some options, for choosing one of them just enter the number!
1 - display inventory
2 - add an item to the inventory
3 - add an random item to the inventory
4 - fill the inventory from file
5 - upgrade the item
6 - exit
-----------------------------------------------------------------
Enter your choice: 6

Process finished with exit code 0
```

## Conclusion

The **Inventory Item Upgrade System** is a simple yet effective tool for managing and upgrading items in an inventory. 

