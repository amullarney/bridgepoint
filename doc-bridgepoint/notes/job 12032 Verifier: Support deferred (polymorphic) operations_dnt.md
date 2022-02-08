---

This work is licensed under the Creative Commons CC0 License

---

# Verifier support for deferred operations
### xtUML Project Design Note

### 1. Abstract

Many of the tool chain components support operations which are realized in subtypes.
Support this capability in Verifier

### 2. Document References

<a id="2.1"></a>2.1 [#10129 support deferred operations in OAL](https://support.onefact.net/issues/10129)

<a id="2.2"></a>2.2 [#12032 Verifier: Support deferred (polymorphic) operations](https://support.onefact.net/issues/12032)  

### 3. Background

3.1 Terminology
. Deferred operations are invoked on a supertype class but may be implemented in a subtype class.
. Deferred operations are restricted to instance-based operations.
. A `required` deferral means that each subtype provide an implementation of the deferred operation
. An `optional` deferral allows a supertype implementation to default when a subtype has no implementation.

### 4. Requirements

4.1 Deferred operations in Verifier should mirror the behavior of the other tool chain components.

### 5. Analysis

5.1 There are two cases where instance-based operations are invoked. In both cases the designation of the super-subtype association as 
supporting deferred operations must be checked for. If found, the supertype instance involved must be identified, and the association 
navigated to identify the associated subtype instance. The deferred operation can then be located by name match and invoked with the 
supplied parameter values.

### 6. Implementation

. Both Invocation::Operation Invocation.execute() and Value::Operation Value.getValue() were modified to check for deferral.
. Operations on the Subsystem::Deferral class were provided to:
- Identify the supertype instance.
- Identify the subtype instance

- Setup parameter values on new stack frame for execution


None.  

### 7. Unit Test  

An test model was developed to exercise deferred operations with and without arguments and/or return values. Optional and Required 
operations were included.

### 8. User Documentation  
None.   

### 9. Code Changes  


### End


