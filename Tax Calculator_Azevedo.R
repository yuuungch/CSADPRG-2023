#Name: Marquus Joss R.Azevedo
#Section: S11

#function to compute SSS
calculateSSSContrib <- function(monthlySalary){
  sssContrib <- 0.0
  
  # List of values for SSS contribution
  valuesList <- list(
    c(4250.0, 4749.99, 202.5),
    c(4750.0, 5249.99, 225.0),
    c(5250.0, 5749.99, 247.5),
    c(5750.0, 6249.99, 270.0),
    c(6250.0, 6749.99, 292.5),
    c(6750.0, 7249.99, 315.0),
    c(7250.0, 7749.99, 337.5),
    c(7750.0, 8249.99, 360.0),
    c(8250.0, 8749.99, 382.5),
    c(8750.0, 9249.99, 405.0),
    c(9250.0, 9749.99, 427.5),
    c(9750.0, 10249.99, 450.0),
    c(10250.0, 10749.99, 472.5),
    c(10750.0, 11249.99, 495.0),
    c(11250.0, 11749.99, 517.5),
    c(11750.0, 12249.99, 540.0),
    c(12250.0, 12749.99, 562.5),
    c(12750.0, 13249.99, 585.0),
    c(13250.0, 13749.99, 607.5),
    c(13750.0, 14249.99, 630.0),
    c(14250.0, 14749.99, 652.5),
    c(14750.0, 15249.99, 675.0),
    c(15250.0, 15749.99, 697.5),
    c(15750.0, 16249.99, 720.0),
    c(16250.0, 16749.99, 742.5),
    c(16750.0, 17249.99, 765.0),
    c(17250.0, 17749.99, 787.5),
    c(17750.0, 18249.99, 810.0),
    c(18250.0, 18749.99, 832.5),
    c(18750.0, 19249.99, 855.0),
    c(19250.0, 19749.99, 877.5),
    c(19750.0, 20249.99, 900.0),
    c(20250.0, 20749.99, 922.5),
    c(20750.0, 21249.99, 945.0),
    c(21250.0, 21749.99, 967.5),
    c(21750.0, 22249.99, 990.0),
    c(22250.0, 22749.99, 1012.5),
    c(22270.0, 23249.99, 1035.0),
    c(23250.0, 23749.99, 1057.5),
    c(23750.0, 24249.99, 1080.0),
    c(24250.0, 24279.99, 1102.5),
    c(24750.0, 25249.99, 1125.0),
    c(25250.0, 25749.99, 1147.5),
    c(25750.0, 26249.99, 1170.0),
    c(26250.0, 26749.99, 1192.5),
    c(26750.0, 27249.99, 1215.0),
    c(27250.0, 27749.99, 1237.5),
    c(27750.0, 28249.99, 1260.0),
    c(28250.0, 28749.99, 1282.5),
    c(28750.0, 29249.99, 1305.0),
    c(29250.0, 29749.99, 1327.5),
    c(29750.0, 1350.0)
  )
  
  #criteria for sss contributions for a specific monthly salary
  for(i in 1:(length(valuesList) - 1)){
    if (monthlySalary < 4250){
      sssContrib <- 180.0
      break
    }
    if (monthlySalary >= valuesList[[i]][1] & monthlySalary <=valuesList[[i]][2]){
      sssContrib <- valuesList[[i]][3]
      break
    }
    if (i == length(valuesList) - 1){
      sssContrib <- 1350.0
      break
    }
  }
  return(sssContrib)
}

#function to compute PhilHealth contributions
calculatePhilhealthContrib <- function(monthlySalary) {
  philhealthContrib <- 0.0
  
  #criteria for philhealth contributions to a specific monthly salary
  if(monthlySalary <= 10000){
    philhealthContrib <- 400.0 / 2
  }else if (monthlySalary > 10000 & monthlySalary < 80000){
    philhealthContrib <- (monthlySalary * 0.04) / 2
  }else if (monthlySalary >= 80000){
    philhealthContrib <- 3200.0
  }
  return(philhealthContrib)
}

#function to compute Pag-IBIG contributions
calculatePagibigContrib <- function(monthlySalary){
  pagibigContrib <- 0.0
  
  #criteria for pag-ibig contributions to a specific monthly salary
  if(monthlySalary <= 1500){
    pagibigContrib <- monthlySalary * 0.01
  }else if(monthlySalary > 1500 & monthlySalary < 5000){
    pagibigContrib <- monthlySalary * 0.02
  }else {
    pagibigContrib <- 100.0
  }
  
  return(pagibigContrib)
}

#function to compute taxes
calculateTax <- function(monthlyIncome){
  tax <- 0.0
  
  #criteria for tax of a specific monthly income
  if(monthlyIncome <= 20833){
    tax <- 0.0
  }else if(monthlyIncome >= 20833 & monthlyIncome < 33333){
    tax <- ((monthlyIncome - 20833.0) * 0.20)
  }else if(monthlyIncome >= 33333 & monthlyIncome < 66667){
    if(monthlyIncome - 33333.0 <= 0){
      tax <- 2500.0
    }else{
      tax <- 2500.0 + ((monthlyIncome - 33333.0) * 0.25)
    }
  }else if(monthlyIncome >= 66667 & monthlyIncome < 166667){
    if(monthlyIncome - 66667.0 <= 0){
      tax <- 10833.33
    }else{
      tax <- 10833.33 + ((monthlyIncome - 66667.0) * 0.30)
    }
  }else if(monthlyIncome >= 166667 & monthlyIncome < 666667){
    if(monthlyIncome - 166667.0 <= 0){
      tax <- 40833.33
    }else{
      tax <- 40833.33 + ((monthlyIncome - 166667.0) * 0.32)
    }
  }else if(income >= 666667){
    if(monthlyIncome - 666667.0 <= 0){
      tax <- 200833.33
    }else{
      tax <- 200833.33 + ((monthlyIncome - 666667.0) * 0.35)
    }
  }
  
  return(tax)
}

#function to get total deduction from sss, philhealth, and pag-ibig
getTotalDeduction <- function(monthlySalary){
  sssContrib <- calculateSSSContrib(monthlySalary)
  philhealthContrib <- calculatePhilhealthContrib(monthlySalary)
  pagibigContrib <- calculatePagibigContrib(monthlySalary)
  return(sssContrib + philhealthContrib + pagibigContrib)
}

#function to compute for taxable income
calculateTaxableIncome <- function(monthlySalary){
  taxableIncome <- monthlySalary - getTotalDeduction(monthlySalary)
  return(taxableIncome)
}

#function to compute for income tax
calculateTaxIncome <- function(monthlySalary){
  taxableIncome <- monthlySalary - getTotalDeduction(monthlySalary)
  taxIncome <- calculateTax(taxableIncome)
  return(taxIncome)
}

#function to compute for net pay after tax
calculateafterTaxIncome <- function(monthlySalary){
  taxableIncome <- monthlySalary - getTotalDeduction(monthlySalary)
  taxIncome <- calculateTax(taxableIncome)
  afterTaxIncome <- monthlySalary - taxIncome
  return(afterTaxIncome)
}

#function to compute for total contributions
calculateTotalContrib <- function(monthlySalary){
  totalContrib <- getTotalDeduction(monthlySalary)
  return(totalContrib)
}

#function to compute for total deductions
calculateTotalDeduction <- function(monthlySalary){
  taxableIncome <- monthlySalary - getTotalDeduction(monthlySalary)
  taxIncome <- calculateTax(taxableIncome)
  totalContrib <- getTotalDeduction(monthlySalary)
  totalDeduct <- taxIncome + totalContrib
  return(totalDeduct)
}

#function to compute for net pay after deductions
calculateafterNetPay <- function(monthlySalary){
  taxableIncome <- monthlySalary - getTotalDeduction(monthlySalary)
  taxIncome <- calculateTax(taxableIncome)
  totalContrib <- getTotalDeduction(monthlySalary)
  totalDeduct <- taxIncome + totalContrib
  netPay <- monthlySalary - totalDeduct
  return(netPay)
}

#main program
cat("Tax Calculator Philippines\n")
salaryInput <- as.numeric(readline("Enter Monthly Salary: "))

#Output Display
cat("Tax Computation:\n")
cat("Taxable Income: Php ", calculateTaxableIncome(salaryInput), "\n")
cat("Income Tax: Php ", calculateTaxIncome(salaryInput), "\n")
cat("Monthly Net Pay after Tax: Php ", calculateafterTaxIncome(salaryInput), "\n\n")

cat("Contributions:\n")
cat("SSS: Php ", calculateSSSContrib(salaryInput), "\n")
cat("PhilHealth: Php ", calculatePhilhealthContrib(salaryInput), "\n")
cat("Pag-IBIG: Php ", calculatePagibigContrib(salaryInput), "\n")
cat("Total Contributions: Php ", calculateTotalContrib(salaryInput), "\n\n")

cat("Total Deductions: Php ", calculateTotalDeduction(salaryInput), "\n")
cat("Monthly Net Pay after Deductions: Php ", calculateafterNetPay(salaryInput), "\n")
