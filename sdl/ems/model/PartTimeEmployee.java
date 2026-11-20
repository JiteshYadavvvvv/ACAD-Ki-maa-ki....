
package ems.model;

import ems.services.*;

public class PartTimeEmployee extends Employee implements TaxCalculable {
    public PartTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    public double calculateTax() {
        return salary * 0.05;
    }
}
