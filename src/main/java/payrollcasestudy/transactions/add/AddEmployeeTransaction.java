
package payrollcasestudy.transactions.add;

import payrollcasestudy.boundaries.PayrollDatabase;
import payrollcasestudy.entities.Employee;
import payrollcasestudy.entities.paymentclassifications.PaymentClassification;
import payrollcasestudy.entities.paymentmethods.PaymentMethod;
import payrollcasestudy.entities.paymentschedule.PaymentSchedule;
import payrollcasestudy.transactions.Transaction;

/**
 * 
 */
public abstract class AddEmployeeTransaction implements Transaction
{

	private int employeeId;
	private String employeeName;
	private String employeeAddress;

	public AddEmployeeTransaction( int employeeId, String employeeName,
			String employeeAddress )
	{
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
	}

	/**
	 * create employee, set its composite attributes and save to database
	 */
	@Override
	public void execute( )
	{		
		Employee employee = new Employee( employeeId,
				employeeName,
				employeeAddress );
		
		PaymentClassification paymentClassification = getPaymentClassification( );
		employee.setPaymentClassification( paymentClassification );
		PaymentSchedule paymentSchedule = getPaymentSchedule( );
		employee.setPaymentSchedule( paymentSchedule );

		PayrollDatabase.globalPayrollDatabase.addEmployee( employeeId,
				employee );
	}

	protected abstract PaymentSchedule getPaymentSchedule( );

	protected abstract PaymentClassification getPaymentClassification( );
}
