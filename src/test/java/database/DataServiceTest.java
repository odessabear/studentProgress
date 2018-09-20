package database;

import entity.Discipline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;


@RunWith(PowerMockRunner.class)
@PrepareForTest(DBConection.class)
public class DataServiceTest {

    private DataService subject;

    @Mock
    private DBConection conection;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        PowerMockito.mockStatic(DBConection.class);
        given(DBConection.createConnection()).willReturn(this.conection);

        this.subject = new DataService();
    }

    @Test
    public void getAllDisciplines() {
        //GIVEN
        List<Discipline> expectedDisciplines = constructListOfDisciplines();
        given(this.conection.getAllDisciplines()).willReturn(expectedDisciplines);

        //WHEN
        List<Discipline> actualDisciplines = this.subject.getAllDisciplines();

        //THEN
        assertThat(actualDisciplines, equalTo(expectedDisciplines));
    }

    private List<Discipline> constructListOfDisciplines() {
        List<Discipline> disciplines = new ArrayList<>();
        disciplines.add(new Discipline(1, "MATH"));
        disciplines.add(new Discipline(2, "HISTRORY"));

        return disciplines;
    }
}