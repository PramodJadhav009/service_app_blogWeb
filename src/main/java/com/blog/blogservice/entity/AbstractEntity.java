package com.blog.blogservice.entity;

import java.io.Serializable;

/**
 * Abstract Entity class.
 *
 */
public abstract class AbstractEntity implements Serializable {
  private static final long serialVersionUID = 6275193640055804438L;

  public abstract Object getPrimaryKey();

}
