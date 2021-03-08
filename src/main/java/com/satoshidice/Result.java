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
  public long id;
  public String depositTxHash;
  public int vout;
  public String payoutTxHash;
  public String serverSeedHash;
  public String randomSeed;
  public String serverSeedTx;
  public int bet;
  public int roll;
  public boolean win;
  public double betAmount;
  public double refunded;
  public boolean overmax;
  public double payout;
  public String timestamp;
  public long timestampUnix;
  public String seedPublishTimestamp;
  public long seedPublishTimestampUnix;
  public int logVersion;
  public boolean broadcasted;
  public int status;
}

@Data
public class Result{
  public int status;
  public String message;
  public Payload payload;
}

