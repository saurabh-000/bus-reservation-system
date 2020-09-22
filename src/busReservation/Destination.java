/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busReservation;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "destination", catalog = "bus_reservation", schema = "")
@NamedQueries({
    @NamedQuery(name = "Destination.findAll", query = "SELECT d FROM Destination d")
    , @NamedQuery(name = "Destination.findById", query = "SELECT d FROM Destination d WHERE d.id = :id")
    , @NamedQuery(name = "Destination.findByDestination", query = "SELECT d FROM Destination d WHERE d.destination = :destination")
    , @NamedQuery(name = "Destination.findByFare", query = "SELECT d FROM Destination d WHERE d.fare = :fare")
    , @NamedQuery(name = "Destination.findBySeat", query = "SELECT d FROM Destination d WHERE d.seat = :seat")})
public class Destination implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "destination")
    private String destination;
    @Basic(optional = false)
    @Column(name = "fare")
    private int fare;
    @Basic(optional = false)
    @Column(name = "seat")
    private int seat;

    public Destination() {
    }

    public Destination(Integer id) {
        this.id = id;
    }

    public Destination(Integer id, String destination, int fare, int seat) {
        this.id = id;
        this.destination = destination;
        this.fare = fare;
        this.seat = seat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        String oldDestination = this.destination;
        this.destination = destination;
        changeSupport.firePropertyChange("destination", oldDestination, destination);
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        int oldFare = this.fare;
        this.fare = fare;
        changeSupport.firePropertyChange("fare", oldFare, fare);
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        int oldSeat = this.seat;
        this.seat = seat;
        changeSupport.firePropertyChange("seat", oldSeat, seat);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Destination)) {
            return false;
        }
        Destination other = (Destination) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "busReservation.Destination[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
