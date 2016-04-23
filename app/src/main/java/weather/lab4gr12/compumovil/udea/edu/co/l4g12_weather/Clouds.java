package weather.lab4gr12.compumovil.udea.edu.co.l4g12_weather;

import com.google.gson.annotations.Expose;

/**
 * Created by kundan on 8/8/2015.
 */
public class Clouds {

    @Expose
    private Integer all;

    /**
     *
     * @return
     * The all
     */
    public Integer getAll() {
        return all;
    }

    /**
     *
     * @param all
     * The all
     */
    public void setAll(Integer all) {
        this.all = all;
    }
}
