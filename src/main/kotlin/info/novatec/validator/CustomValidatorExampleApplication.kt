package info.novatec.validator

import info.novatec.validator.api.validators.ClaimNumberValidatorRuntimeHints
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ImportRuntimeHints

@ImportRuntimeHints(ClaimNumberValidatorRuntimeHints::class)
@SpringBootApplication
class CustomValidatorExampleApplication

fun main(args: Array<String>) {
	runApplication<CustomValidatorExampleApplication>(*args)
}

