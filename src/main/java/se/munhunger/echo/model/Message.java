package se.munhunger.echo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Marcus Münger on 2017-08-07.
 */
@Entity
@Table(name = "message")
@ApiModel(value = "message")
public class Message
{
    @Id
    @Column(name = "message_id")
    @ApiModelProperty(value = "A unique identifier that is attached to the ID")
    public String id;

    @Column(name = "message")
    @ApiModelProperty(value = "The saved message")
    public String message;

    public Message()
    {}

    public Message(String id, String message)
    {
        this.id = id;
        this.message = message;
    }
}
