/********************
Name: Argamosa, Daniel; Azevedo, Marquus; Kua, Miguel; Yung Cheng, Adrian
Language: Kotlin
Paradigm: Multi-Paradigm - Object-Oriented Programming, Functional Programming
********************/

import javax.swing.*
import java.awt.*
import java.awt.event.*

class User {
    private var salary: Double
    private var taxableIncome: Double
    private var incomeTax: Double
    private var afterIncomeTax: Double
    private var sss: Double
    private var philHealth: Double
    private var pagIbig: Double
    private var totalContributions: Double
    private var totalDeductions: Double
    private var netPay: Double


    constructor() {
        salary = 0.0
        taxableIncome = 0.0
        incomeTax = 0.0
        afterIncomeTax = 0.0
        sss = 0.0
        philHealth = 0.0
        pagIbig = 0.0
        totalContributions = 0.0
        totalDeductions = 0.0
        netPay = 0.0
    }

    public fun computeSSS(salary: Double): Double {
        var sss : Double = 0.0

        var minValue = 1000.0
        var maxValue = 3249.99

        val values = doubleArrayOf(135.0, 157.5, 180.0, 202.5, 225.0, 247.5, 270.0, 292.5, 315.0, 337.5, 360.0, 382.5, 405.0, 427.5, 450.0, 472.5, 495.0, 517.5, 540.0, 562.5, 585.0, 607.5, 630.0, 652.5, 675.0, 697.5, 720.0, 742.5,  765.0, 787.5,  810.0,  832.5, 855.0, 877.5, 900.0, 922.5, 945.0, 967.5, 990.0, 1012.5, 1035.0, 1057.5, 1080.0, 1102.5, 1125.0)

        
        for (i in 0..(values.size - 1)) {

            if(salary < 1000.0) {
                sss = 135.0
                break
            }

            if(salary >= minValue && salary <= maxValue) {
                sss = values[i]
                break
            }
            else {
                if(minValue == 1000.0) {
                    minValue = 3250.0
                    maxValue = 3749.99
                } else {
                    minValue += 500.0
                    maxValue += 500.0
                }
            }

            if(minValue >= 24750.0) {
                sss = 1125.0
                break
            }
        }
        return sss
    }

    public fun computePhilHealth(salary: Double): Double {
        var philHealth : Double = 0.0

        if (salary <= 10000) {
            philHealth = 400.0 / 2
        } else if (salary > 10000 && salary < 80000) {
            philHealth = (salary * 0.04) / 2
        } else if (salary >= 80000) {
            philHealth = 3200.0 / 2
        }
        return philHealth
    }

    public fun computePagIbig(salary: Double): Double {
        var pagIbig : Double

        if (salary <= 1500) {
            pagIbig = salary * 0.01
        } else if (salary > 1500 && salary < 5000){
            pagIbig = salary * 0.02
        } else {
            pagIbig = 100.0
        }
        return pagIbig
    }

    public fun computeTax(income: Double): Double {
        var tax : Double = 0.0

        if(income <= 20833) {
            tax = 0.0
        } else if(income >= 20833 && income < 33333) {
            tax = ((income - 20833.0) * 0.20)
        } else if(income >= 33333 && income < 66667) {
            if(income - 33333.0 <= 0)
                tax = 2500.0
            else
                tax = 2500.0 + ((income - 33333.0) * 0.25)
        } else if(income >= 66667 && income < 166667) {
            if(income - 66667.0 <= 0)
                tax = 10833.33
            else
                tax = 10833.33 + ((income - 66667.0) * 0.30)
        } else if(income >= 166667 && income < 666667) {
            if(income - 166667.0 <= 0)
                tax = 40833.33
            else
                tax = 40833.33 + ((income - 166667.0) * 0.32)
        } else if(income >= 666667) {
            if(income - 666667.0 <= 0)
                tax = 200833.33
            else
                tax = 200833.33 + ((income - 666667.0) * 0.35)
        }

        return tax
    }

    public fun getDeductions(salary: Double): Double {
        var sss = computeSSS(salary)
        var philhealth = computePhilHealth(salary)
        var pagibig = computePagIbig(salary)
        return sss + philhealth + pagibig
    }

    public fun compute(salary: Double) {
        // Compute taxes
        taxableIncome = salary - getDeductions(salary)
        incomeTax = computeTax(taxableIncome)
        afterIncomeTax = salary - incomeTax

        // Compute contributions
        sss = computeSSS(salary)
        philHealth = computePhilHealth(salary)
        pagIbig = computePagIbig(salary)
        totalContributions = getDeductions(salary)

        // Compute deductions
        totalDeductions = incomeTax + totalContributions
        netPay = salary - totalDeductions
    }

    public fun getSalary() : Double {
        return salary
    }

    public fun setSalary(entry : Double) {
        salary = entry
    }

    public fun getTaxableIncome() : Double {
        return taxableIncome
    }
    
    public fun getIncomeTax() : Double {
        return incomeTax
    }

    public fun getAfterIncomeTax() : Double {
        return afterIncomeTax
    }

    public fun getSSS() : Double {
        return sss
    }

    public fun getPhilHealth(): Double {
        return philHealth
    }

    public fun getPagIbig() : Double {
        return pagIbig
    }

    public fun getTotalContributions() : Double {
        return totalContributions
    }

    public fun getTotalDeductions() : Double {
        return totalDeductions
    }

    public fun getNetPay() : Double {
        return netPay
    }


    public fun tester() {
        val user = User()
        println("Tax Calculator Philippines")

        print("Enter Monthly Salary: ")
        var input = readLine()!!.toDouble()

        while(input < 0.0) {
            println("Invalid input!")

            print("Enter Monthly Salary: ")
            input = readLine()!!.toDouble()
        }

        user.setSalary(input)

        user.compute(user.getSalary())

        // Display output
        println("Income Tax: Php ${user.getIncomeTax()}")
        println("Net Pay after Tax: Php ${user.getAfterIncomeTax()}\n")

        println("SSS Contribution: Php ${user.getSSS()}")
        println("PhilHealth Contribution: Php ${user.getPhilHealth()}")
        println("Pag-IBIG Contribution: Php ${user.getPagIbig()}")
        println("Total Contributions: ${user.getTotalContributions()}\n")

        println("Total Deductions: Php ${user.getTotalDeductions()}")
        println("Net Pay after Deductions: Php ${user.getNetPay()}")
    }
}

class TaxCalculator : JFrame("Philippines Tax Calculator") {
    
    private val text = Font("Century Gothic", Font.BOLD, 12)
    private val result = Font("Garamond", Font.BOLD, 13)

    private val salaryLabel = JLabel("Monthly Salary:")
    private val salaryField = JTextField(10)

    private val computeButton = JButton("Compute Tax")
    private val taxableIncomeLabel = JLabel("Taxable Income:")
    private val taxableIncomeField = JTextField(10)

    private val incomeTaxLabel = JLabel("Income Tax:")
    private val incomeTaxField = JTextField(10)

    private val afterIncomeTaxLabel = JLabel("After Income Tax:")
    private val afterIncomeTaxField = JTextField(10)

    private val sssLabel = JLabel("SSS Contribution:")
    private val sssField = JTextField(10)

    private val philHealthLabel = JLabel("PhilHealth Contribution:")
    private val philHealthField = JTextField(10)

    private val pagIbigLabel = JLabel("Pag-IBIG Contribution:")
    private val pagIbigField = JTextField(10)

    private val totalContributionsLabel = JLabel("Total Contributions:")
    private val totalContributionsField = JTextField(10)

    private val totalDeductionsLabel = JLabel("Total Deductions:")
    private val totalDeductionsField = JTextField(10)

    private val netPayLabel = JLabel("Net Pay:")
    private val netPayField = JTextField(10)

    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(600, 400)
        setLocationRelativeTo(null)
        layout = GridLayout(9,3,10,10)
        
        salaryLabel.setFont(text)
        computeButton.setFont(text)
        taxableIncomeLabel.setFont(text)
        sssLabel.setFont(text)
        philHealthLabel.setFont(text)
        pagIbigLabel.setFont(text)
        incomeTaxLabel.setFont(text)
        totalContributionsLabel.setFont(text)
        totalDeductionsLabel.setFont(text)
        netPayLabel.setFont(text)

        salaryField.setFont(result)
        taxableIncomeField.setFont(result)
        sssField.setFont(result)
        incomeTaxField.setFont(result)
        philHealthField.setFont(result)
        afterIncomeTaxField.setFont(result)
        pagIbigField.setFont(result)
        totalContributionsField.setFont(result)
        totalDeductionsField.setFont(result)
        netPayField.setFont(result)

        add(JLabel())
        add(salaryLabel)
        add(salaryField)
        add(JLabel())

        add(JLabel())
        add(JLabel())

        add(computeButton)
        add(JLabel())

        add(taxableIncomeLabel)
        add(taxableIncomeField)

        add(sssLabel)
        add(sssField)

        add(incomeTaxLabel)
        add(incomeTaxField)

        add(philHealthLabel)
        add(philHealthField)

        add(afterIncomeTaxLabel)
        add(afterIncomeTaxField)

        add(pagIbigLabel)
        add(pagIbigField)

        add(JLabel())
        add(JLabel())

        add(totalContributionsLabel)
        add(totalContributionsField)

        add(JLabel())
        add(JLabel())
        add(JLabel())
        add(JLabel())

        add(JLabel())

        add(totalDeductionsLabel)
        add(totalDeductionsField)

        add(JLabel())

        add(JLabel())

        add(netPayLabel)
        add(netPayField)

        add(JLabel())

        computeButton.addActionListener {
            var salary = salaryField.text.toDoubleOrNull()
            if (salary != null) {
                if(salary > 0.0) {
                    val user = User()
                    user.compute(salary)

                    taxableIncomeField.text = user.getTaxableIncome().toString()
                    incomeTaxField.text = user.getIncomeTax().toString()
                    afterIncomeTaxField.text = user.getAfterIncomeTax().toString()
                    sssField.text = user.getSSS().toString()
                    philHealthField.text = user.getPhilHealth().toString()
                    pagIbigField.text = user.getPagIbig().toString()
                    totalContributionsField.text = user.getTotalContributions().toString()
                    totalDeductionsField.text = user.getTotalDeductions().toString()
                    netPayField.text = user.getNetPay().toString()
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid input!")
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid input!")
            }
        }
    }
}

fun main() {
    val user = User()

    var choice : Int

    println("[1] Text-Based\n[2] GUI")

    print("Enter choice: ")

    choice = readLine()!!.toInt()

    if(choice == 1)
        user.tester()
    else if(choice == 2)
        TaxCalculator().isVisible = true
}
