package builders;


import groovy.transform.builder.Builder;

@Builder
public enum Status {
    available, pending, sold
}
