
package payrollcasestudy.transactions.change;

import payrollcasestudy.entities.Employee;

public class ChangeNameTransaction extends ChangeEmployeeTransaction
{

	private String name;

	public ChangeNameTransaction( int employeeId, String name )
	{
		super( employeeId );
		this.name = name;
	}

	@Override
	public void changeEmployee( Employee employee )
	{
		employee.setName( name );
	}
}
