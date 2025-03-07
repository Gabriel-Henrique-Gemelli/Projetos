package Projeto_Enum.entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Projeto_Enum.enums.WorkerLevel;

public class Worker {
    
    private String name;
    private WorkerLevel level;
    private Double baseSalary;
    
    private Department department;
    private List<HourContract> contracts = new ArrayList<>();
    
    public Worker() {
        
    }

    public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }
    
    public void addContract(HourContract contract) {
        contracts.add(contract);
    }
    
    public void removeContract(HourContract contract) {
        contracts.remove(contract);
    }
    
    public double income(int year, int month) { // Corrigido o nome do método para seguir convenção Java
        double sum = baseSalary;
        Calendar cal = Calendar.getInstance();
        for (HourContract c : contracts) { // Seguindo convenção, variáveis de loop geralmente são minúsculas
            cal.setTime(c.getDate());
            int cYear = cal.get(Calendar.YEAR);
            int cMonth = 1 + cal.get(Calendar.MONTH); // Calendar.MONTH começa de 0, então soma-se 1
            if (year == cYear && month == cMonth) {
                sum += c.totalValue();
            }
        }
        return sum;
    }
}
