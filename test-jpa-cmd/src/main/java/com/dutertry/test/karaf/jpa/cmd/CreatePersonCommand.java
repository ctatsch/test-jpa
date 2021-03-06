package com.dutertry.test.karaf.jpa.cmd;

import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Argument;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;
import com.dutertry.test.karaf.jpa.entities.Person;
import com.dutertry.test.karaf.jpa.service.TestService;

/**
 *
 * @author ndutertry
 */
@Command(scope = "person", name = "create", description = "create a person")
@Service
public class CreatePersonCommand implements Action {

    @Argument(index = 0, name = "lastName", description = "Last name", required = true, multiValued = false)
    private String lastName;

    @Argument(index = 1, name = "age", description = "Age", required = true, multiValued = false)
    private int age;
    
    @Reference
    private TestService testService;

    @Override
    public Object execute() throws Exception {
        Person person = new Person();
        person.setLastName(lastName);
        person.setAge(age);
        
        testService.create(person);
        
        return null;
    }

}
