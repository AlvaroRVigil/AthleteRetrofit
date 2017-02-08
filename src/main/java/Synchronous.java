import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.io.IOException;
import java.util.List;

public class Synchronous {
    private static Retrofit retrofit;

    public static void main(String[] args) throws IOException {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        AthleteService athleteService = retrofit.create(AthleteService.class);

        Call<List<Athlete>> call = athleteService.getAllAthletes();
        Response<List<Athlete>> response= call.execute();

        if(response.isSuccessful()) {
            List<Athlete> athletesList = response.body();
            System.out.println("- Mostrar Todos");
            System.out.println("  Codigo: " + response.code() + System.lineSeparator() +
                    "  GET: " + athletesList);
        } else {
            System.out.println(" Error: " + response.errorBody());
        }
        // ------------------------------------------------------------------------------------------------------------------------
        Athlete Athlete = new Athlete();
        Athlete.setNombre("Dan");
        Athlete.setApellidos("Jonson");
        Athlete.setNacionalidad("Es");
        Call<Athlete> callAthlete = athleteService.createAthlete(Athlete);
        Response<Athlete> responseAthlete= callAthlete.execute();

        if(responseAthlete.isSuccessful()) {
            System.out.println("- Insert.");
            Athlete athleteResp = responseAthlete.body();
            System.out.println("  Codigo: " + responseAthlete.code() + System.lineSeparator() +
                    "  Atleta añadido: " + athleteResp);

            athleteResp.setApellidos("Fisher");
            callAthlete = athleteService.updateAthlete(athleteResp);
            responseAthlete= callAthlete.execute();

            System.out.println("- Modificar");
            System.out.println("  Codigo: " + responseAthlete.code() + System.lineSeparator() +
                    "  Atleta modificado: " + responseAthlete.body());

            // ------------------------------------------------------------------------------------------------------------------------
            call = athleteService.getAllAthletes();
            response= call.execute();
            System.out.println("- Comprobación " + System.lineSeparator() +
                    "  Codigo: " + response.code() + System.lineSeparator() +
                    "  GET todos atletas: " + response.body());

            // ------------------------------------------------------------------------------------------------------------------------
            Call<Void> callDelete= athleteService.deleteAthlete(athleteResp.getId());
            Response<Void> responseDelete= callDelete.execute();
            System.out.println("- Borrar");
            System.out.println("  Codigo: " + responseDelete.code());

            // ---------------------------------------------------------------------------------------------------------------------
            call = athleteService.getAllAthletes();
            response= call.execute();
            System.out.println("- Comprobación del delete " + System.lineSeparator() +
                    "  Codigo: " + response.code() + System.lineSeparator() +
                    "  GET todos atletas: " + response.body());
        } else {
            System.out.println("Error al añadir!");
            System.out.println("  Error: " + responseAthlete.errorBody());
        }

        // ------------------------------------------------------------------------------------------------------------------------
        callAthlete = athleteService.getAthlete(23L);
        responseAthlete = callAthlete.execute();

        if(responseAthlete.isSuccessful()) {
            System.out.println("- Atleta con id 23" + System.lineSeparator() +
                    "  Codigo: " + responseAthlete.code() + System.lineSeparator() +
                    "  Atleta: " + responseAthlete.body() );
        }else{
            System.out.println("ERROR 'CONTROL'");
        }
    }
}