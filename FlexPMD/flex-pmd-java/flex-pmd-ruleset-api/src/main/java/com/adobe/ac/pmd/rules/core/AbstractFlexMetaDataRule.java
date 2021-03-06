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
package com.adobe.ac.pmd.rules.core;

import java.util.List;

import com.adobe.ac.pmd.nodes.IAttribute;
import com.adobe.ac.pmd.nodes.IClass;
import com.adobe.ac.pmd.nodes.IFunction;
import com.adobe.ac.pmd.nodes.IMetaDataListHolder;

/**
 * @author xagnetti
 */
public abstract class AbstractFlexMetaDataRule extends AbstractAstFlexRule
{
   /*
    * (non-Javadoc)
    * @see
    * com.adobe.ac.pmd.rules.core.AbstractAstFlexRule#findViolations(com.adobe
    * .ac.pmd.nodes.IClass)
    */
   @Override
   protected final void findViolations( final IClass classNode )
   {
      super.findViolations( classNode );

      if ( classNode.getMetaDataCount() > 0 )
      {
         findViolationsFromMetaDataList( classNode );
         findViolationsFromClassMetaData( classNode );
      }
   }

   /*
    * (non-Javadoc)
    * @see
    * com.adobe.ac.pmd.rules.core.AbstractAstFlexRule#findViolations(com.adobe
    * .ac.pmd.nodes.IFunction)
    */
   @Override
   protected final void findViolations( final IFunction function )
   {
      if ( function.getMetaDataCount() > 0 )
      {
         findViolationsFromMetaDataList( function );
         findViolationsFromFunctionMetaData( function );
      }
   }

   /**
    * @param function
    */
   protected void findViolationsFromAttributeMetaData( final IAttribute attribute )
   {
   }

   /*
    * (non-Javadoc)
    * @see
    * com.adobe.ac.pmd.rules.core.AbstractAstFlexRule#findViolationsFromAttributes
    * (java.util.List)
    */
   @Override
   protected final void findViolationsFromAttributes( final List< IAttribute > variables )
   {
      for ( final IAttribute attribute : variables )
      {
         if ( attribute.getMetaDataCount() > 0 )
         {
            findViolationsFromMetaDataList( attribute );
            findViolationsFromAttributeMetaData( attribute );
         }
      }
   }

   /**
    * @param classNode
    */
   protected void findViolationsFromClassMetaData( final IClass classNode )
   {
   }

   /**
    * @param function
    */
   protected void findViolationsFromFunctionMetaData( final IFunction function )
   {
   }

   /**
    * @param holder
    */
   protected void findViolationsFromMetaDataList( final IMetaDataListHolder holder )
   {
   }
}