package hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.adapters.primary.admin.gui.validation.field;

import java.util.stream.Collectors;

import javax.inject.Inject;

import hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.adapters.primary.admin.gui.formatters.controller.msg.FieldValidatorErrorFormatter;
import hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.adapters.primary.admin.gui.validation.ValidationErrorMessagesModel;

public class FieldValidationErrorPresenter {
	private FieldValidatorErrorFormatter fieldValidatorErrorFormatter;
	
	@Inject
	public FieldValidationErrorPresenter(
			FieldValidatorErrorFormatter fieldValidatorErrorFormatter
			) {
		this.fieldValidatorErrorFormatter = fieldValidatorErrorFormatter;
	}

	public ValidationErrorMessagesModel present(FieldValidatorException e) {
		return new ValidationErrorMessagesModel(
				e.fieldValidatorErrors.stream()
					.map(it -> fieldValidatorErrorFormatter.format(it))
					.collect(Collectors.toList())
				);
	}

}
