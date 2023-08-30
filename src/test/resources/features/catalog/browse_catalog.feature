Feature: Browse the product catalog
  Rule: Customers should see the best-selling products on the catalog page
    Example: Customer sees top-selling products
      When Sean is logged onto the application
      Then he should be presented with following products
      | Title               | Price    |
      |Sauce Labs Backpack  | $29.99   |
      |Sauce Labs Bike Light| $9.99    |

