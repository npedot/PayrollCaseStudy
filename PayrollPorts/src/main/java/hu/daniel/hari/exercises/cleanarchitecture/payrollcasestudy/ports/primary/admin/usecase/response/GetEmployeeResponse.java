package hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.ports.primary.admin.usecase.response;

import hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.ports.primary.admin.usecase.response.employee.EmployeeBaseForResponse;

public class GetEmployeeResponse implements Response {
	public EmployeeForGetEmployeeResponse employeeForGetEmployeeResponse;
	
	public GetEmployeeResponse(EmployeeForGetEmployeeResponse employeeForGetEmployeeResponse) {
		this.employeeForGetEmployeeResponse = employeeForGetEmployeeResponse;
	}

	public static class EmployeeForGetEmployeeResponse extends EmployeeBaseForResponse {
	}
}
