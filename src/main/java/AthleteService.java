import retrofit2.Call;
import retrofit2.http.*;
import java.util.List;

import static javax.swing.text.html.FormSubmitEvent.MethodType.POST;
import static sun.plugin2.message.JavaScriptSlotOpMessage.GET;

public interface AthleteService {
    @GET("/athlete")
    Call<List<Athlete>> getAllAthletes();

    @GET("/athlete/{id}")
    Call<Athlete> getAthlete(@Path("id") Long id);

    @GET("/atheleteError")
    Call<List<Athlete>> getError();

    @POST("/athlete")
    Call<Athlete> createAthlete(@Body Athlete Athlete);

    @PUT("/athlete")
    Call<Athlete> updateAthlete(@Body Athlete Athlete);

    @DELETE("/athlete/{id}")
    Call<Void> deleteAthlete(@Path("id") Long id);
}