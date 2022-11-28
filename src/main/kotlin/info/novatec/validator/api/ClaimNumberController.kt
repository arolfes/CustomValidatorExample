package info.novatec.validator.api

import info.novatec.validator.api.validators.ClaimNumber
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/claimNumber")
@Validated
class ClaimNumberController {

    @GetMapping("/{claimNumber}/isValid")
    fun isClaimNumberValid(
            @PathVariable
            @ClaimNumber
            claimNumber: String
    ): Boolean {
        return true
    }
}