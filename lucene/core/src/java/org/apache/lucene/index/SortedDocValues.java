package org.apache.lucene.index;

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.lucene.util.BytesRef;

// nocommit need marker interface?
public abstract class SortedDocValues {
  // nocommit throws IOE or not?
  public abstract int getOrd(int docID);

  // nocommit throws IOE or not?
  public abstract void lookupOrd(int ord, BytesRef result);

  // nocommit throws IOE or not?
  public abstract int getValueCount();

  // nocommit binary search lookup?
  public static final SortedDocValues DEFAULT = new SortedDocValues() {
      
      @Override
      public int getOrd(int docID) {
        return 0;
      }

      @Override
      public void lookupOrd(int ord, BytesRef ret) {
        if (ord != 0) {
          throw new IllegalArgumentException("ord should be 0");
        }
        ret.length = 0;
      }

      @Override
      public int getValueCount() {
        return 1;
      }
    };

}