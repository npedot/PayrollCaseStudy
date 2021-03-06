package hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.ports.primary.admin.usecase.request.changeemployee.affiliation;

import hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.ports.primary.admin.usecase.exception.UseCaseException;

public class UnionMemberIdAlreadyExistsException extends UseCaseException {
	public int ownerEmployeeId;
	public String ownerEmployeeName;
	public UnionMemberIdAlreadyExistsException(int ownerEmployeeId, String ownerEmployeeName) {
		this.ownerEmployeeId = ownerEmployeeId;
		this.ownerEmployeeName = ownerEmployeeName;
	}
}
