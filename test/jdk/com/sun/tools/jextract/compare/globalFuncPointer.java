/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package com.acme;

import java.foreign.annotations.NativeAddressof;
import java.foreign.annotations.NativeCallback;
import java.foreign.annotations.NativeGetter;
import java.foreign.annotations.NativeHeader;
import java.foreign.annotations.NativeSetter;
import java.foreign.memory.Callback;
import java.foreign.memory.Pointer;

@NativeHeader(
    path="globalFuncPointer.h",
    globals={"<u64(fp):(*)v"}
)
public interface globalFuncPointer {
    @NativeGetter("fp")
    Callback<FI1> fp$get();
    @NativeSetter("fp")
    void fp$set(Callback<FI1> fi1);
    @NativeAddressof("fp")
    Pointer<Callback<FI1>> fp$ptr();

    @FunctionalInterface
    @NativeCallback("(*)v")
    public interface FI1 {
        void fn(Object...args);
    }
}
