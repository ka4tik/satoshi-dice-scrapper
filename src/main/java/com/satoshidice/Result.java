package com.satoshidice;// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString), Root.class); */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bet_results")
 class Payload{

 @Id
  public Long id;
  public String depositTxHash;
  public Integer vout;
  public String payoutTxHash;
  public String serverSeedHash;
  public String randomSeed;
  public String serverSeedTx;
  public Integer bet;
  public Integer roll;
  public Boolean win;
  public Double betAmount;
  public Double refunded;
  public Boolean overmax;
  public Double payout;
  public String timestamp;
  public Long timestampUnix;
  public String seedPublishTimestamp;
  public Long seedPublishTimestampUnix;
  public Integer logVersion;
  public Boolean broadcasted;
  public Integer status;
}

@Data
public class Result{
  public Integer status;
  public String message;
  public Payload payload;
}

