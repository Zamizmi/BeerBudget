  **Users:** for persons whom waits for the first of May
  
**User** actions
  - Create a budget
    - Add MoneyFlow -objects
      - Income
      - Expense
    - Set current date
    - See the balance
    - List all MoneyFlows
    -
 
**Usage**
  The application is used to create a budget with all the incomes and expenses.
  1. Tell your current balance
  2. Tell your target you wish to save
  3. Tell the current date
  4. Choose a command
    - list
      - Lists all the available commands
    - moneyflow
      - asks input for (i)ncome or (e)xpense
      - asks name for the object
      - asks amount
      - asks repeatance
      - asks for expiratron date

    - incomes
      - Lists all coming the incomes, showing name, amount and due date
      - Delete an income
    - expenses
      - Lists all coming the expenses, showing name, amount and due date
      - Delete an expense
    - budget
      - Shows all information of the budget
    - target
      - Prints when your target has been completed with the current budget or if it never will be.
    - First of May
      - Shows how many days to MayDay
      - Counts how many beers user can buy with the current budget at next First of May
      
**Structure**
-The main objects are Budget and Moneyflow.
-Date object takes care of time management and DateLogic manipulates Dates.
-Tools contains important input manipulation methods.
-BudgetLogic takes care of making changes to Budget and creating new MoneyFlows
-GUI is the allround Interface using JavaFX
      
Class Diagram for the Application

![ClassDiagram](/Documentation/BeerBudget1.png)

Sequence Diagram: Add new Income

![Sequence Diagram: add new Income](/Documentation/allIncomes.png)

Sequence Diagram: Print all Incomes

![Sequence Diagram: Print all Incomes](/Documentation/sequenceNewIncome.png)
