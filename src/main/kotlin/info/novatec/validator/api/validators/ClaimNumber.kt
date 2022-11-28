package info.novatec.validator.api.validators

import jakarta.validation.Constraint
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import jakarta.validation.Payload
import org.springframework.aot.hint.MemberCategory
import org.springframework.aot.hint.RuntimeHints
import org.springframework.aot.hint.RuntimeHintsRegistrar
import kotlin.annotation.AnnotationTarget.VALUE_PARAMETER
import kotlin.reflect.KClass

@Target(VALUE_PARAMETER)
@MustBeDocumented
@Constraint(validatedBy = [ClaimNumberValidator::class])
annotation class ClaimNumber(
        val message: String = "ClaimNumber must 11 chars long and start with 'KR'",
        val groups: Array<KClass<*>> = [],
        val payload: Array<KClass<out Payload>> = []
)

class ClaimNumberValidator: ConstraintValidator<ClaimNumber, String> {
    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        return value!=null && value.trim().length == 11 && value.trim().startsWith("KR")
    }

}

class ClaimNumberValidatorRuntimeHints : RuntimeHintsRegistrar {
    override fun registerHints(hints: RuntimeHints, classLoader: ClassLoader?) {
        hints.reflection().registerType(ClaimNumberValidator::class.java, MemberCategory.INVOKE_PUBLIC_CONSTRUCTORS)
    }
}