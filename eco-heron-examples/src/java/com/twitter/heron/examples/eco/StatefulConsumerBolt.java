//  Copyright 2018 Twitter. All rights reserved.
//
//  Licensed under the Apache License, Version 2.0 (the "License");
//  you may not use this file except in compliance with the License.
//  You may obtain a copy of the License at
//
//  http://www.apache.org/licenses/LICENSE-2.0
//
//  Unless required by applicable law or agreed to in writing, software
//  distributed under the License is distributed on an "AS IS" BASIS,
//  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//  See the License for the specific language governing permissions and
//  limitations under the License.
package com.twitter.heron.examples.eco;

import java.util.Map;

import com.twitter.heron.api.bolt.BaseRichBolt;
import com.twitter.heron.api.bolt.OutputCollector;
import com.twitter.heron.api.state.State;
import com.twitter.heron.api.topology.IStatefulComponent;
import com.twitter.heron.api.topology.OutputFieldsDeclarer;
import com.twitter.heron.api.topology.TopologyContext;
import com.twitter.heron.api.tuple.Tuple;


public class StatefulConsumerBolt extends BaseRichBolt
    implements IStatefulComponent<Integer, Integer> {
  private static final long serialVersionUID = -5470591933906954522L;

  private OutputCollector collector;
  private State<Integer, Integer> myState;

  @Override
  public void initState(State<Integer, Integer> state) {
    this.myState = state;
  }

  @Override
  public void preSave(String checkpointId) {
    // Nothing really since we operate out of the system supplied state
  }

  @SuppressWarnings("rawtypes")
  public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
    collector = outputCollector;
  }

  @Override
  public void execute(Tuple tuple) {
    int key = tuple.getInteger(0);
    System.out.println("looking in state for: " + key);
    if (myState.get(key) == null) {
      System.out.println("did not find " + key + " in state: ");
      myState.put(key, 1);
    } else {
      System.out.println("found in state: " + key);
      Integer val = myState.get(key);
      myState.put(key, ++val);
    }
  }

  @Override
  public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
  }
}
