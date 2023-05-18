package com.codeline.sampleProject.RequestObjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetSalaryRequestObject {
    Double amount;

    String currency;

    Double overTimeAmount;
}
