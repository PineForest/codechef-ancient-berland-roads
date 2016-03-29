/*
 * Copyright © 2016  David Williams
 *
 * This file is part of the codechef-ancient-berland-roads project.
 *
 * codechef-ancient-berland-roads is free software: you can redistribute it and/or modify it under the terms of the
 * Lesser GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * codechef-ancient-berland-roads is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the Lesser GNU General Public
 * License for more details.
 *
 * You should have received a copy of the Lesser GNU General Public License along with codechef-ancient-berland-roads.
 * If not, see <a href="http://www.gnu.org/licenses/">www.gnu.org/licenses/</a>.
 */

package my.code.library.util;

public class StateCorruptedException extends RuntimeException {
    static final long serialVersionUID = -7064897190445766919L;

    public StateCorruptedException() {
    }

    public StateCorruptedException(String message) {
        super(message);
    }

    public StateCorruptedException(String message, Throwable cause) {
        super(message, cause);
    }

    public StateCorruptedException(Throwable cause) {
        super(cause);
    }

    public StateCorruptedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
