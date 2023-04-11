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

        val values = arrayOf(
        doubleArrayOf(4250.0, 4749.99, 202.5),
        doubleArrayOf(4750.0, 5249.99, 225.0),
        doubleArrayOf(5250.0, 5749.99, 247.5),
        doubleArrayOf(5750.0, 6249.99, 270.0),
        doubleArrayOf(6250.0, 6749.99, 292.5),
        doubleArrayOf(6750.0, 7249.99, 315.0),
        doubleArrayOf(7250.0, 7749.99, 337.5),
        doubleArrayOf(7750.0, 8249.99, 360.0),
        doubleArrayOf(8250.0, 8749.99, 382.5),
        doubleArrayOf(8750.0, 9249.99, 405.0),
        doubleArrayOf(9250.0, 9749.99, 427.5),
        doubleArrayOf(9750.0, 10249.99, 450.0),
        doubleArrayOf(10250.0, 10749.99, 472.5),
        doubleArrayOf(10750.0, 11249.99, 495.0),
        doubleArrayOf(11250.0, 11749.99, 517.5),
        doubleArrayOf(11750.0, 12249.99, 540.0),
        doubleArrayOf(12250.0, 12749.99, 562.5),
        doubleArrayOf(12750.0, 13249.99, 585.0),
        doubleArrayOf(13250.0, 13749.99, 607.5),
        doubleArrayOf(13750.0, 14249.99, 630.0),
        doubleArrayOf(14250.0, 14749.99, 652.5),
        doubleArrayOf(14750.0, 15249.99, 675.0),
        doubleArrayOf(15250.0, 15749.99, 697.5),
        doubleArrayOf(15750.0, 16249.99, 720.0),
        doubleArrayOf(16250.0, 16749.99, 742.5),
        doubleArrayOf(16750.0, 17249.99, 765.0),
        doubleArrayOf(17250.0, 17749.99, 787.5),
        doubleArrayOf(17750.0, 18249.99, 810.0),
        doubleArrayOf(18250.0, 18749.99, 832.5),
        doubleArrayOf(18750.0, 19249.99, 855.0),
        doubleArrayOf(19250.0, 19749.99, 877.5),
        doubleArrayOf(19750.0, 20249.99, 900.0),
        doubleArrayOf(20250.0, 20749.99, 922.5),
        doubleArrayOf(20750.0, 21249.99, 945.0),
        doubleArrayOf(21250.0, 21749.99, 967.5),
        doubleArrayOf(21750.0, 22249.99, 990.0),
        doubleArrayOf(22250.0, 22749.99, 1012.5),
        doubleArrayOf(22270.0, 23249.99, 1035.0),
        doubleArrayOf(23250.0, 23749.99, 1057.5),
        doubleArrayOf(23750.0, 24249.99, 1080.0),
        doubleArrayOf(24250.0, 24279.99, 1102.5),
        doubleArrayOf(24750.0, 25249.99, 1125.0),
        doubleArrayOf(25250.0, 25749.99, 1147.5),
        doubleArrayOf(25750.0, 26249.99, 1170.0),
        doubleArrayOf(26250.0, 26749.99, 1192.5),
        doubleArrayOf(26750.0, 27249.99, 1215.0),
        doubleArrayOf(27250.0, 27749.99, 1237.5),
        doubleArrayOf(27750.0, 28249.99, 1260.0),
        doubleArrayOf(28250.0, 28749.99, 1282.5),
        doubleArrayOf(28750.0, 29249.99, 1305.0),
        doubleArrayOf(29250.0, 29749.99, 1327.5),
        doubleArrayOf(29750.0, 1350.0)
        )
        
        for (i in 1..(values.size - 1)) {

            if(salary < 4250) {
                sss = 180.0
                break
            }

            if(salary >= values[i][0] && salary <= values[i][1]) {
                sss = values[i][2]
                break
            }

            if(i == values.size - 1) {
                sss = 1350.0
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
            philHealth = 3200.0
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


    public fun Tester() {
        //     val user = User()
        //     println("Tax Calculator Philippines")
        //     print("Enter Monthly Salary: ")
        //     var input = readLine()!!.toDouble()

        //     user.setSalary(input)

        //     user.compute(user.getSalary())

        //     // Display output
        //     println("Income Tax: Php ${user.getIncomeTax()}")
        //     println("Net Pay after Tax: Php ${user.getAfterIncomeTax()}\n")

        //     println("SSS Contribution: Php ${user.getSSS()}")
        //     println("PhilHealth Contribution: Php ${user.getPhilHealth()}")
        //     println("Pag-IBIG Contribution: Php ${user.getPagIbig()}")
        //     println("Total Contributions: ${user.getTotalContributions()}\n")

        //     println("Total Deductions: Php ${user.getTotalDeductions()}")
        //     println("Net Pay after Deductions: Php ${user.getNetPay()}")
    }
}

class TaxCalculator : JFrame("Philippines Tax Calculator") {
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
        setSize(400, 400)
        setLocationRelativeTo(null)
        layout = GridLayout(12, 2)

        add(salaryLabel)
        add(salaryField)

        add(JLabel())
        add(computeButton)

        add(taxableIncomeLabel)
        add(taxableIncomeField)

        add(incomeTaxLabel)
        add(incomeTaxField)

        add(afterIncomeTaxLabel)
        add(afterIncomeTaxField)

        add(sssLabel)
        add(sssField)

        add(philHealthLabel)
        add(philHealthField)

        add(pagIbigLabel)
        add(pagIbigField)

        add(totalContributionsLabel)
        add(totalContributionsField)

        add(totalDeductionsLabel)
        add(totalDeductionsField)

        add(netPayLabel)
        add(netPayField)

        computeButton.addActionListener {
            val salary = salaryField.text.toDoubleOrNull()
            if (salary != null) {
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
        }
    }
}

fun main() {
    TaxCalculator().isVisible = true
}
