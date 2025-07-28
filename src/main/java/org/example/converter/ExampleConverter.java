package org.example.converter;

import org.example.entity.api.ExampleResponse;
import org.example.entity.jpa.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class ExampleConverter {

    public ExampleResponse convert(Example example) {
        return new ExampleResponse(example.getId().toString(), example.getMessage());
    }

    public ExampleResponse convert(Optional<Example> example) {
        return example.map(this::convert).orElse(null);

    }

    public List<ExampleResponse> convert(Iterable<Example> examples) {
        return StreamSupport.stream(examples.spliterator(), false).map(
                this::convert).toList();
    }
}
