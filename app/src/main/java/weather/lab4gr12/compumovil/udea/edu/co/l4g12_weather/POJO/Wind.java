package weather.lab4gr12.compumovil.udea.edu.co.l4g12_weather.POJO;

import com.google.gson.annotations.Expose;

/**
 * Created by kundan on 8/8/2015.
 */
public class Wind {

    @Expose
    private Double speed;
    @Expose
    private Double deg;

    /**
     *
     * @return
     * The speed
     */
    public Double getSpeed() {
        return speed;
    }

    /**
     *
     * @param speed
     * The speed
     */
    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    /**
     *
     * @return
     * The deg
     */
    public Double getDeg() {
        return deg;
    }

    /**
     *
     * @param deg
     * The deg
     */
    public void setDeg(Double deg) {
        this.deg = deg;
    }
}
