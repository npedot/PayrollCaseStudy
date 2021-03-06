package hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.tests.integration.usecase.usecases.changeaffiliation;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

import org.junit.Test;

import hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.app.entity.Employee;
import hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.app.entity.affiliation.NoAffiliation;
import hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.ports.primary.admin.usecase.request.addemployee.AddSalariedEmployeeRequest;
import hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.ports.primary.admin.usecase.request.changeemployee.affiliation.AddUnionMemberAffiliationRequest;
import hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.ports.primary.admin.usecase.request.changeemployee.affiliation.RemoveUnionMemberAffiliationRequest;
import hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.tests.integration.usecase.AbstractMultipleDatabaseUseCaseTest;

public class RemoveUnionMemberAffiliationUseCaseITTest extends AbstractMultipleDatabaseUseCaseTest {

	private int employeeId = 1;
	private int unionMemberId = 7000;

	public RemoveUnionMemberAffiliationUseCaseITTest(TestDatabaseProvider testDatabaseProvider) {
		super(testDatabaseProvider);
	}
	
	@Test
	public void testRemoveUnionMemberAffiliationUseCase() {
		givenAUnionMemberAffiliatedEmployee();
		whenRemovingUnionAffiliation();
		thenItShouldHaveNoAffiliation(database.employeeGateway().findById(employeeId));
	}

	private void givenAUnionMemberAffiliatedEmployee() {
		useCaseFactories.addSalariedEmployeeUseCase().execute(new AddSalariedEmployeeRequest(employeeId, "", "", 0));
		useCaseFactories.addUnionMemberAffiliationUseCase().execute(new AddUnionMemberAffiliationRequest(employeeId, unionMemberId, 0));
	}

	private void whenRemovingUnionAffiliation() {
		useCaseFactories.removeUnionMemberAffiliationUseCase().execute(new RemoveUnionMemberAffiliationRequest(unionMemberId));
	}

	private void thenItShouldHaveNoAffiliation(Employee employee) {
		assertThat(employee.getAffiliation(), instanceOf(NoAffiliation.class));
	}
}
