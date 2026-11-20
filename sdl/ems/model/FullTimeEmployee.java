
package ems.model;

import ems.services.*;

public class FullTimeEmployee extends Employee implements TaxCalculable {
    public FullTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    public double calculateTax() {
        return salary * 0.10;
    }
}
