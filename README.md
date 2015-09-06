# CheckoutKata

This is the initail code that meets the kata/specification.

Improvments in the future could include:
* A database with all the prices
* Each item could have a quantity instead of being added to a List inside the scannedItems Map, this would allow only a SKU to be passed to the scanItem method and would reduce the overhead.
* A database with the discounts confugure so that they can be configured seperatly and read into objects by the provider.
* Spring autowiring to allow things to be replaced for testing purposes

The assumptiosn made are:
* The price can be read as each item is scanned as this is a supermarket and the prices will not be updated in working hours.
* Discounts will follow the same principle.
