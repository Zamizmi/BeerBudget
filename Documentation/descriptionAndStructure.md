  **Users:** for persons whom waits for the first of May
  
**User** actions
  - Create a budget
    - Add MoneyFlow -objects
    - Set current date
    - See the balance
    - List all MoneyFlows
    
**TODO**
  - Count the beers till First of May
  - Better user interface -> sanitates the user input
  - Add functionality to properly check the MoneyFlows
  - Add functionality to count when the target is accomplished with the current budget
  - Save the budget to a file and continue working with it later
  
 
**Usage**
  The application is used to create a budget with all the incomes and expenses.
  1. Tell your current balance
  2. Tell your target you wish to save
  3. Choose a command(atm user needs to write it completely sameway)
    - list
      - Lists all the available commands
    - moneyflow
      - asks input for (i)ncome or (e)xpense
      - asks name for the object
      - asks amount
      - asks repeatance
      - asks for date

    - incomes
      - Lists all the incomes, and the sum of them till the end of current month
    - expenses
      - Lists all the expenses, and the sum of them till the end of current month
    - balance(todo)
      - Update balance
      - Shows the current balance
      - Shows the approximated balance at the end of month
    - budget(todo)
      - Shows all information of the budget
    - target(todo)
      - Update target
      - Prints when your target has been completed with the current budget
    - First of May(todo)
      - Counts how many beers user can buy with the current budget at next First of May
    - exit
      - Exits
      
Class Diagram for the Application

![ClassDiagram](/Documentation/BeerBudget.png)
